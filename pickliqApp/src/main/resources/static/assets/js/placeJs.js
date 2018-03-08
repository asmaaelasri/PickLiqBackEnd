$(document).ready(function() {
	$('#bootstrap-data-table-export').DataTable();
});

var modal = document.getElementById('myModal');

$(document).ready(function() {
$('.table').children(":nth-child(2)").children().each(function(){
	var id=$(this).children().first().text();
	$(this).attr("id",id);
	
});});
$(document).ready(function() {
$('.table').on('click', '.edit-row', function(e) {
	e.preventDefault();
var row = $(this).parent().parent();
	var id=row.children().first().text();

	
	
	
	
	modal.style.display = "block";
	$.getJSON("/place/getPlace/"+id, null, function () {});

	$("#placeName").attr("value",$("#"+id).children(":nth-child(2)").text())
	$("#placeAddress").attr("value",$("#"+id).children(":nth-child(3)").text())
	$("#placeLatitude").attr("value",$("#"+id).children(":nth-child(4)").text())
	$("#placeLongitude").attr("value",$("#"+id).children(":nth-child(5)").text())
	$("#payment-button").click( function() {
		$.getJSON("/place/edit/"+$("#placeName").val()+"/"+$("#placeAddress").val()+"/"+$("#placeLatitude").val()+"/"+$("#placeLongitude").val()+"/"+id, null, function () {}); 
		location.reload();
	});
	
})});



// Get the button that opens the modal
var btn = document.getElementsByClassName("myBtn")[1];

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];





// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}