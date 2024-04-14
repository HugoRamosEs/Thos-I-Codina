$(function () {
  function saveData() {
    let en_curs = $("#en_curs ul").html();
    let finalitzat = $("#finalitzat ul").html();

    let dadesKanban = {
      curs: en_curs,
      fin: finalitzat,
    };

    localStorage.setItem("dades_kanban", JSON.stringify(dadesKanban));
  }

  $("#per_fer ul, #en_curs ul, #finalitzat ul")
  .sortable({
    connectWith: "#per_fer ul, #en_curs ul, #finalitzat ul",
    start: function (event, ui) {
      ui.item.css("transform", "scale(1.1)");
    },
    stop: function (event, ui) {
      ui.item.css("transform", "scale(1)");
      saveData();
      updateProgressBar();
    },
    revert: 200,
  })
  .disableSelection();

  $("#per_fer ul").sortable({
    receive: function (event, ui) {
      ui.item.find(".item").removeClass("fin");
      ui.item.find(".item").removeClass("curs");
    },
  });

  $("#en_curs ul").sortable({
    receive: function (event, ui) {
      ui.item.find(".item").removeClass("fin");
      ui.item.find(".item").addClass("curs");
    },
  });

  $("#finalitzat ul").sortable({
    receive: function (event, ui) {
      ui.item.find(".item").removeClass("curs");
      ui.item.find(".item").addClass("fin");
    },
  });

  $("#restaurar")
    .button()
    .on("click", function () {
      console.log("hola");
      localStorage.removeItem("dades");
      localStorage.removeItem("dades_kanban");
      location.reload();
    });

  function updateProgressBar() {
    let total = $(
      "#per_fer ul li:not(.hidden, .ui-sortable-handle), #en_curs ul li:not(.hidden, .ui-sortable-handle), #finalitzat ul li:not(.hidden, .ui-sortable-handle)"
    ).filter(function () {
      return (
        $(this).text().trim() !== "" && $(this).find("div.hidden").length === 0
      );
    }).length;

    let acabats = $(
      "#finalitzat ul li:not(.hidden, .ui-sortable-handle)"
    ).filter(function () {
      return (
        $(this).text().trim() !== "" && $(this).find("div.hidden").length === 0
      );
    }).length;

    let progres = total > 0 ? (acabats / total) * 100 : 100;

    $("#pbar").progressbar("value", progres);
    $("#pbar .pbar-label").text(Math.round(progres) + "%");
  }

  $("#pbar").progressbar({
    value: 100,
  });

  function loadData() {
    let dadesObtingudes = JSON.parse(localStorage.getItem("dades"));
    let dadesKanban = JSON.parse(localStorage.getItem("dades_kanban"));

    if (dadesObtingudes) {
      let sprintTr = $(dadesObtingudes.sprint);
      sprintTr.each(function () {
        let tr = $(this);
        if (!tr.hasClass("placeholder")) {
          let tasca = tr.find("td").eq(0).text();
          let tipus = tr.find("td").eq(1).text();
          let dataI = tr.find("td").eq(2).text();
          let dataF = tr.find("td").eq(3).text();

          if (tasca && tipus && dataI && dataF) {
            let item = $(
              '<li><div class="item"><h4></h4><h5></h5><p>Data d\'inici: </p><p>Data final: </p></div></li>'
            );
            item.find("h4").text(tasca);
            item.find("h5").text(tipus);
            item.find("p").eq(0).append(dataI);
            item.find("p").eq(1).append(dataF);

            $("#per_fer ul").append(item);

            updateProgressBar();
          }
        }
      });
    }

    if (dadesKanban) {
      $("#en_curs ul").html(dadesKanban.curs);
      $("#finalitzat ul").html(dadesKanban.fin);

      let en_curs_item = $("#en_curs ul li .item");
      let finalitzat_item = $("#finalitzat ul li .item");

      $("#per_fer ul li .item").each(function () {
        let per_fer_item = $(this);
        let duplicat =
          en_curs_item.is(function () {
            return $(this).html() === per_fer_item.html();
          }) ||
          finalitzat_item.is(function () {
            return $(this).html() === per_fer_item.html();
          });

        if (duplicat) {
          per_fer_item.addClass("hidden");
        }
      });
    }

    updateProgressBar();
  }

  $(loadData);
});
