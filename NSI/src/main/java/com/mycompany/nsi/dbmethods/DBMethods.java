package com.mycompany.nsi.dbmethods;

import com.mycompany.nsi.model.NSIList;
import com.mycompany.nsi.model.NSIModel;
import java.sql.*;

public class DBMethods {
    public static NSIList getList() throws Exception, SQLException {
        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://msk3git.vniizht.lan:5432/lp2db";
        String user = "asupvreader";
        String password = "reader2022";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        StringBuilder query = new StringBuilder();
        query.append(" select vp_inv, prm_gr, prm_x, prm_name, vp_zn, nsi_name from asupv.params ");
        query.append(" inner join asupv.vpasp on vpasp.vp_x = params.prm_x and current_date between prm_datan and prm_datak ");
        query.append(" left join asupv.nsiasupv on vp_zn = nsiasupv.nsi_kod and prm_spr = nsi_spr and current_date between nsi_datani and nsi_dataki ");
        query.append(" where params.prm_gr = '0004' and vp_inv = 46458 and prm_type = 'S' and current_timestamp between vp_tsn and vp_tsk and vp_delts = '2100-01-01 23:59:59' ");
        ResultSet result = statement.executeQuery(query.toString());

        NSIList list = new NSIList();
        while (result.next()) {
            NSIModel model = new NSIModel();
            model.setVp_inv(result.getInt("vp_inv"));
            model.setPrm_gr(result.getString("prm_gr"));
            model.setPrm_x(result.getInt("prm_x"));
            model.setPrm_fname(result.getString("prm_name"));
            model.setVp_zn(result.getString("vp_zn"));
            model.setNsi_fname(result.getString("nsi_name"));
            list.addElement(model);
        }
                
        result.close();
        statement.close();
        connection.close(); 
                
        return list;
    }
    
    public static NSIModel getDoc(int prm_x) throws Exception, SQLException {
        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://msk3git.vniizht.lan:5432/lp2db";
        String user = "asupvreader";
        String password = "reader2022";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        StringBuilder query = new StringBuilder();
        query.append(" select vp_inv, prm_gr, prm_x, prm_fname, vp_zn, nsi_fname from asupv.params ");
        query.append(" inner join asupv.vpasp on vpasp.vp_x = params.prm_x and current_date between prm_datan and prm_datak ");
        query.append(" left join asupv.nsiasupv on vp_zn = nsiasupv.nsi_kod and prm_spr = nsi_spr and current_date between nsi_datani and nsi_dataki ");
        query.append(" where params.prm_gr = '0004' and vp_inv = 46458 and prm_type = 'S' and current_timestamp between vp_tsn and vp_tsk and vp_delts = '2100-01-01 23:59:59' and prm_x = ");
        query.append(prm_x);
        ResultSet result = statement.executeQuery(query.toString());

        NSIModel doc = new NSIModel();
        if (result.next()) {
            doc.setVp_inv(result.getInt("vp_inv"));
            doc.setPrm_gr(result.getString("prm_gr"));
            doc.setPrm_x(result.getInt("prm_x"));
            doc.setPrm_fname(result.getString("prm_fname"));
            doc.setVp_zn(result.getString("vp_zn"));
            doc.setNsi_fname(result.getString("nsi_fname"));
        }
                
        result.close();
        statement.close();
        connection.close(); 
                
        return doc;
    }
}
