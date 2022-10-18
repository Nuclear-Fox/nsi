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
        for (let note in data.list[line])
        {
            let td = document.createElement('td');
            let val = document.createTextNode(data.list[line][note].toString());
            td.appendChild(val);
            td.setAttribute('label', document.getElementById(note)['innerText']);//название столбца
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
}
