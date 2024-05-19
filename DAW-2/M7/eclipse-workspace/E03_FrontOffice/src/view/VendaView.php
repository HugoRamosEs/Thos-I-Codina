<?php
namespace view;

header("Content-Type: text/html; charset=utf-8");

class VendaView {
    
    public static function events($events) {
        $div = '<form action="" method="post" class="main-venda-events">';
        
        foreach ($events as $e) {
            $img = $e->getImatge();
            if (strpos($img, "img/") !== false) {
                $img = str_replace("img/", "", $img);
            }
            
            $subtitol = $e->getSubtitol() !== null ? iconv("UTF-8", "ISO-8859-1", $e->getSubtitol()) : null;
            
            $div .= '<button type="submit" id="' . $e->getId() . '" name="esdeveniment_id" value="' . $e->getId() . '" >
                        <div class="event">
                            <img src="../src/img/' . $img . '" alt="' . $img . '">
                            <div class="text">
                                <h3>' . iconv("UTF-8", "ISO-8859-1", $e->getTitol()) . '</h3>
                                <p>' . $subtitol . '</p>
                            </div>
                        </div>
                     </button>';
        }
        
        $div .= '</form>';
        
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-venda.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function localitzacions($localitzacions, $e) {
        $img = $e->getImatge();
        if (strpos($img, "img/") !== false) {
            $img = str_replace("img/", "", $img);
        }
        
        $div = '<div class="main-venda">
                    <img src="../src/img/' . $img . '" alt="' . $img . '">
                    <div class="text">
                        <h3>Localització</h3>
                        <p>Has seleccionat el següent esdeveniment:' . iconv("UTF-8", "ISO-8859-1", $e->getTitol()) . "</p>" .
                       "<p>Si us plau, selecciona amb precisió la ubicació on vols experimentar l’esdeveniment.
                           Assegura't de que la ubicació seleccionada sigui l’adequada abans de procedir al següent pas. </p>" .
                       '<form action="" method="post">
                            <select id="localitzacio_id" name="localitzacio_id">';
               foreach ($localitzacions as $l) {
                        $div .= "<option value='" . $l->getId() . "'>" . iconv("UTF-8", "ISO-8859-1", $l->getLloc()) . "</option>";
               }
                                        
                    $div .= '</select>
                             <input type="submit" id="submit_loc" name="submit_loc">
                        </form>
                    </div>
               </div>';
 
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-venda.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function dates($dates) {
        $div = '<div class="main-venda">
                    <img src="../src/img/data.png" alt="Data">
                    <div class="text">
                        <h3>Data i Hora</h3>' .
                        "<p>Si us plau, selecciona la data i l'hora en la qual vols experimentar l’esdeveniment. Assegura't de 
                            que la data i hora seleccionades siguin les adequades abans de procedir al següent pas.</p>" .
                        '<form action="" method="post">
                            <select id="data_id" name="data_id">';
               foreach ($dates as $d) {
                    $div .= "<option value='" . $d->getId() . "'>" . $d->getData() . " - " . $d->getHora() . "</option>";
               }

                   $div .= '</select>
                            <input type="submit" id="submit_data" name="submit_data">
                        </form>
                    </div>
               </div>';

        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-venda.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function zones($zones, $frmErrors) {
        $div = '<div class="main-venda">
                    <img src="../src/img/zonas.png" alt="Zones">
                    <div class="text">
                        <h3>Zona i Seient</h3>' .
                        "<p>Si us plau, selecciona amb precisió la ubicació on vols experimentar l’esdeveniment.
                            Assegura't de que la ubicació seleccionada sigui l’adequada abans de procedir al següent pas.</p>" .
                        '<form action="" method="post">
                            <select id="zona_id" name="zona_id">';
        foreach ($zones as $z) {
            $div .= "<option value='" . $z->getId() . "'>" . $z->getDescripcio() . "</option>";
        }
        
                    $div .= '</select>
                            <input type="text" id="fila" name="fila" placeholder="Número de fila...">
                            <div class="errors"><span class="error">' . $frmErrors["fila1"] . '</span></div> 
                            <div class="errors"><span class="error">' . $frmErrors["fila2"] . '</span></div> 
                            <div class="errors"><span class="error">' . $frmErrors["fila3"] . '</span></div> 
                            <input type="text" id="butaca" name="butaca" placeholder="Número de butaca...">
                            <div class="errors"><span class="error">' . $frmErrors["butaca1"] . '</span></div> 
                            <div class="errors"><span class="error">' . $frmErrors["butaca2"] . '</span></div>
                            <div class="errors"><span class="error">' . $frmErrors["butaca3"] . '</span></div>
                            <input type="submit" id="submit_zona" name="submit_zona">
                        </form>
                    </div>
               </div>';
        
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-venda.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function pagament($frmErrors) {
        $div = '<div class="main-venda">
                    <img src="../src/img/pagament.jpg" alt="Pagament">
                    <div class="text">
                        <h3>Pagament</h3>' .
                        "<p>Si us plau, introdueix les teves dades de pagament per poder adquirir l'entrada per a l’esdeveniment.
                            Assegura't de que les dades siguin correctes abans de procedir.</p>" .
                        '<form action="" method="post">
                            <input type="text" id="dni" name="dni" placeholder="Introdueix el teu DNI...">
                            <div class="errors"><span class="error">' . $frmErrors["dni1"] . '</span></div> 
                            <div class="errors"><span class="error">' . $frmErrors["dni2"] . '</span></div>
                            <input type="text" id="targeta" name="targeta" placeholder="Introdueix la teva targeta...">
                            <div class="errors"><span class="error">' . $frmErrors["targeta1"] . '</span></div>
                            <input type="submit" id="submit_pagament" name="submit_pagament">
                        </form>
                    </div>
               </div>';
        
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-venda.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
    public static function entrada($entrada_id, $responseErrors = null) {
        $div = '<div class="main-venda">
                <img src="../src/img/Entrada.png" alt="Entrada">
                <div class="text">';
        
        if ($responseErrors === null) {
            $div .= '<h3>Entrada</h3>' .
                '<p class="p-entrada">Entrada registrada i generada amb èxit! Fes clic al següent botó per descarregar-la o al botó per tornar a generar un altre: </p>' .
                '<a href="?Venda/generatePdf/' . $entrada_id . '" class="button btn">Descarregar</a>';
        } else {
            $div .= '<h3>Error</h3>' .
                '<p class="p-entrada-error">No s\'ha pogut registrar l\'entrada, per tant no s\'ha generat. Torna a l\'inici per generar una de nova.</p>' .
                '<ul class="error-list">';
            foreach ($responseErrors['errors'] as $error) {
                $div .= '<li class="error">' . $error . '</li>';
            }
            $div .= '</ul>';
        }
        
        $div .= '<a href="?Venda/form/" class="button btn">Tornar</a>';
        $div .= '</div>' .
            '</div>' .
            '</div>';
        
        include __DIR__ . "/../template/head.tpl.php";
        include __DIR__ . "/../template/header.tpl.php";
        include __DIR__ . "/../template/main-venda.tpl.php";
        include __DIR__ . "/../template/footer.tpl.php";
    }
    
}
