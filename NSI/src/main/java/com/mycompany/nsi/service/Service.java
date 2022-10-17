package com.mycompany.nsi.service;

import com.mycompany.nsi.model.*;
import com.mycompany.nsi.dbmethods.DBMethods;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("")
public class Service {
    @GET
    @Path("/getlist")
    @Produces(MediaType.APPLICATION_JSON)
    public NSIList getListJSON() throws Exception, SQLException {
        DBMethods query = new DBMethods();
        NSIList list = new NSIList();
        list = query.getList();
        return list;
    }
    
    @GET
    @Path("/getdoc")
    @Produces(MediaType.APPLICATION_JSON)
    public NSIModel getDocJSON(@QueryParam("prm_x") int prm_x) throws Exception, SQLException {
        DBMethods query = new DBMethods();
        NSIModel doc = new NSIModel();
        doc = query.getDoc(prm_x);
        return doc;
    }
}
