//const data = JSON.parse('{"list":[{"vp_inv":46458, "prm_gr":"0004", "prm_x":"3", "prm_fname":"Специализация вагона", "vp_zn":"0098", "nsi_fname":"для перевозки пассажиров"}, {"vp_inv":46458, "prm_gr":"0004", "prm_x":"3", "prm_fname":"Специализация вагона", "vp_zn":"0098", "nsi_fname":"для перевозки пассажиров"}]}');

let data = {};
let table = document.getElementsByTagName('tbody')[0];

(async () => {
    let url = 'http://localhost:8080/server/nsi/getlist';
    let response = await fetch(url);
    data = await response.json();
    fullTable();
})();

function fullTable()
{
    //заполнение таблицы данными
    for (let line in data.list)
    {
        let tr = document.createElement('tr');
        let prm_x;
        for (let note in data.list[line])
        {
            let td = document.createElement('td');
            if (note === 'prm_x')
                prm_x = data.list[line][note];
            let val = document.createTextNode(data.list[line][note].toString());
            td.appendChild(val);
            td.setAttribute('label', document.getElementById(note)['innerText']);//название столбца
            tr.appendChild(td);
        }
        let tdForm = document.createElement('td');
        tdForm.setAttribute('label', 'Подробнее');
        let form = document.createElement('form');
        form.setAttribute('action', '#openModal'); 
        let but = document.createElement('button');
        but.setAttribute('id', prm_x);
        but.setAttribute('onclick', 'fullWindow(id)');
        let i = document.createTextNode('i'.toString());
        but.appendChild(i);
        form.appendChild(but);
        tdForm.appendChild(form);
        tr.appendChild(tdForm);
        table.appendChild(tr);
    }
}


async function fullWindow(prm_x) {
    let dataDocument = {};

    let url = 'http://localhost:8080/server/nsi/getdoc?prm_x=' + prm_x.toString();
    let response = await fetch(url);
    dataDocument = await response.json();
    
    for (let note in dataDocument) {
        let line = document.getElementById(note + '_doc');
        
        let span = document.createElement('span');
        span.setAttribute('style', 'text-align: right;')
        let param = document.createTextNode(dataDocument[note].toString());
        span.appendChild(param);
        line.append(span);
    }
}

function closeWindow() {
    let p = document.getElementsByTagName('p');
    for (let note in p)
    {
        let pNote = p[note];
        if (!!pNote.getElementsByTagName('span')[0])
            pNote.removeChild(pNote.getElementsByTagName('span')[0]);
    }
}


