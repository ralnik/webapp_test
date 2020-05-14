function readJSON(data) {
	let array = JSON.parse(JSON.stringify(data));       	
	for(i in array) {
		drawRow(array[i])
	}
}

function drawRow(rowData) {
    var row = $("<tr />")
    $("#table").append(row);
    row.append($("<td>" + rowData.color_number + "</td>"));
    row.append($("<td><div class='catside' onclick=rowTextOnClick('" + rowData.color_number + "','" + rowData.name + "')>" + rowData.name + "</div></td>"));
}

function rowTextOnClick(color_number, name) {	
	console.log("button onClick");
	drawColorRow(color_number, name)
}

function drawColorRow(color_number, name) {
    console.log("name: " + name)
    //row.append($("<div style='background-color:red'>" + color_number + ', ' + name + "</div>"));

    document.getElementById("rowColor").innerHTML = color_number + ', ' + name;
    document.getElementById("rowColor").style.backgroundColor = name;
    
}