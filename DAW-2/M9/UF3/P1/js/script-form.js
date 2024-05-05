$(document).ready(function () {
  $("form").submit(function(event) {
    event.preventDefault();
    
    var valid = true;
    var errors = "<h2>Errors</h2><ul>";

    if ($("#select").val() == "") {
      errors += "<li>Selecciona un tipus.</li>";
      valid = false;
    }

    if ($("#name").val() == "") {
      errors += "<li>Has d'introduir un nom.</li>";
      valid = false;
    }

    if ($("#email").val() == "") {
      errors += "<li>Has d'introduir un correu electrònic.</li>";
      valid = false;
    }

    if ($("#message").val() == "") {
      errors += "<li>Has d'introduir un missatge.</li>";
      valid = false;
    }

    var phonePattern = /^[0-9]{9}$/;
    var phoneNumber = $("#phone").val();
    if (phoneNumber !== "" && !phonePattern.test(phoneNumber)) {
      errors += "<li>El telèfon ha de tenir 9 dígits sense guions.</li>";
      valid = false;
    }

    if (!$("#terms").prop("checked")) {
      errors += "<li>Has d'acceptar els termes i condicions.</li>";
      valid = false;
    }

    errors += "</ul>";

    if (!valid) {
      $("#errors").html(errors).show();
      $("#correct").hide();
      return false;
    } else {
      $("#errors").hide();
      $("#correct").html("<p>El formulari s'ha enviat correctament.</p>").show();
      $("form")[0].reset();
    }
  });
});
