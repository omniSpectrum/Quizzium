/* Event Handler for Switches on DASHBOARD,
 * Alex Shkunov, 20.04.2014
 * Done with love, specially for Quizzium*/
$('.stateSwitch').on('switchChange.bootstrapSwitch', 
function(event, state) {
	
	$.post( "Dashboard", 
		{ 
			quizId: this.name, 
			targetState: state 
		},
		//callback function
		function(data) {
			//reload page, parameter 'true' enforces to reload from Server
			location.reload(true);
		}); //END of $.post	
});

function quizziumError(message){
	var alertBox = "<div class=\"alert alert-danger alert-dismissable\">"
			+ "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" "
			+ "aria-hidden=\"true\">&times;</button> "
			+ message + " Try to reload the page"
			+ "</div>";
		
	$(".col-md-12").prepend(alertBox);
}

//Default Ajax error
$(function() {
    $.ajaxSetup({
        error: function(jqXHR, exception) {
            if (jqXHR.status === 0) {
            	quizziumError('Error.\nNot connect. Verify Network.');
            } else if (jqXHR.status == 404) {
            	quizziumError('Error.\nRequested page not found. [404]');
            } else if (jqXHR.status == 500) {
            	quizziumError('Error.\nInternal Server Error [500].');
            } else if (exception === 'parsererror') {
            	quizziumError('Error.\nRequested JSON parse failed.');
            } else if (exception === 'timeout') {
            	quizziumError('Error.\nTime out error.');
            } else if (exception === 'abort') {
            	quizziumError('Error.\nAjax request aborted.');
            } else {
            	quizziumError('Error.\nUncaught Error.\n' + jqXHR.responseText);
            }
        }
    });
});