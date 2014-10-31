 $(document).ready(function() {
            var form = $('#playerMoveForm');
            form.submit(function( event ) {
                var number1 = $("#number1").val();
                var number2 = $("#number2").val();
                $.ajax({
                    type: form.attr('method'),
                    url: form.attr('action'),
                    data: 'number1=' + number1 + '&number2=' + number2
                }).done(function() {
                    $('#playerMoveResult').html('Move successful').attr('class', 'alert alert-success');
                }).fail(function() {
                    $('#playerMoveResult').html('Error, move not submitted').attr('class', 'alert alert-danger');
                });
                event.preventDefault();
            });
        });