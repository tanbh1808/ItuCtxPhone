/**
 * 
 */
function populateCtxtable(table, data) {
	var tr = [];
  	for (var i = 0; i < data.length; i++) {
		//row
		tr[i] = document.createElement('tr');
		
		//Cells
		var upd = document.createElement('td');
		upd.appendChild(document.createTextNode(data[i].updated ) );
		var lat = document.createElement('td');
		lat.appendChild(document.createTextNode(data[i].lat ) );
		var lng = document.createElement('td');
		lng.appendChild(document.createTextNode(data[i].lng ) );
		var sensor = document.createElement('td');
		sensor.appendChild(document.createTextNode(data[i].type ) );
		var values = document.createElement('td');
		values.appendChild(document.createTextNode(data[i].values ) );
		
		//populate row
		tr[i].appendChild(upd);
		tr[i].appendChild(lat);
		tr[i].appendChild(lng);
		tr[i].appendChild(sensor);
		tr[i].appendChild(values);

		//add to table
		table.appendChild( tr[i] );
  	}
};

function populateBeacontable(table, data) {
	var tr = [];
  	for (var i = 0; i < data.length; i++) {
		//row
		tr[i] = document.createElement('tr');
		
		//Cells
		var upd = document.createElement('td');
		upd.appendChild(document.createTextNode(data[i].updated ) );
		var lat = document.createElement('td');
		lat.appendChild(document.createTextNode(data[i].lat ) );
		var lng = document.createElement('td');
		lng.appendChild(document.createTextNode(data[i].lng ) );
		var uid = document.createElement('td');
		uid.appendChild(document.createTextNode(data[i].uid ) );
		var major = document.createElement('td');
		major.appendChild(document.createTextNode(data[i].major ) );
		var minor = document.createElement('td');
		minor.appendChild(document.createTextNode(data[i].minor ) );
		
		//populate row
		tr[i].appendChild(upd);
		tr[i].appendChild(lat);
		tr[i].appendChild(lng);
		tr[i].appendChild(uid);
		tr[i].appendChild(major);
		tr[i].appendChild(minor);

		//add to table
		table.appendChild( tr[i] );
  	}
}