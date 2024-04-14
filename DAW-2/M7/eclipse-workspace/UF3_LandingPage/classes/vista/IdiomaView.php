<?php

class IdiomaView extends View{
    public function __construct(){
        parent::__construct();
    }

    public function show($lang, $idiomes, $langTraduccions){
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);
        
        $thead = '<table id="tIdioma"><thead><tr>';
        $th = array(
            "Imatge",
            "Idioma (ISO)",
            "Actiu",
            "Accions"
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($idiomes as $i) {
            $tbody .= '<tr>
                        <td><img src="' . $i->getImatge() . '" alt="' . $i->getImatge() . '"></td>
                        <td>' . $i->getIso() . '</td>.
                        <td>' . $i->getActiu() . '</td>
                        <td class="mInputs">
                            <a href="?Idioma/form/' . $i->getId() . '"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Idioma/delete/' . $i->getId() . '"><img src="img/eliminar.png" alt="eliminar.img"/></a>
                        </td>
                       </tr>';
        }
        $tbody .= "<tbody></table>";
        $taulaI = $thead . $tbody;

        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-idioma.tpl.php";
        include "templates/footer.tpl.php";
    }

    public function form($lang, $idiomes, $frmErrors, $langTraduccions, $idioma = null){
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);

        $formI = '<form id="form-idioma" action="" method="post" enctype="multipart/form-data">
                    
                    <table>
                        <tr class="th_titol">
                            <td colspan="3" class="td_titol"><h2>Idioma</h2></td>
                        </tr>
                        <tr>
                            <th>Imatge</th>
                            <th>Iso</th>
                            <th>Actiu</th>
                        </tr>
                        <tr>
                            <td>
                                <input type="file" id="imatge" name="imatge">
                                <span class="error">' . $frmErrors["imatge1"] . '</span>
                                <span class="error">' . $frmErrors["imatge2"] . '</span>
                                <span class="error">' . $frmErrors["imatge3"] . '</span>
                                <span class="error">' . $frmErrors["imatge4"] . '</span>
                            </td>
                            <td>
                                <input type="text" id="iso" name="iso" placeholder="Escriu un iso..." value="' . ($idioma ? $idioma->getIso() : "") . '">
                                <span class="error">' . $frmErrors["iso1"] . '</span>
                                <span class="error">' . $frmErrors["iso2"] . '</span>
                            </td>
                            <td>
                                <select id="actiu" name="actiu">
                                    <option value="0"' . ($idioma && $idioma->getActiu() == "0" ? " selected" : "") . '>Inactiu</option>
                                    <option value="1"' . ($idioma && $idioma->getActiu() == "1" ? " selected" : "") . '>Actiu</option>
                                </select>
                                <span class="error">' . $frmErrors["actiu"] . '</span>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3" class="td_titol">
                                <h2>Traduccions</h2>
                                <span class="error">' . $frmErrors["traduccio"] . '</span>
                            </td>
                        </tr>';
        if ($idioma == null){
            $formI .= '<tr>
                         <th colspan="3">Variable propia</th>
                       </tr>
                       <tr>
                         <td colspan="3">
                          <input type="text" id="variable-propia" name="variable-propia" placeholder="Escriu una traducció per al propi idioma..." value="">
                          <span class="error">' . $frmErrors["variable-propia"] . '</span>
                         </td>
                      </tr>';
        }
        $formI .= '<tr>
                    <th>Imatge</th>
                    <th>Iso</th>
                    <th>Variable</th>
                   </tr>';

        foreach ($idiomes as $i) {
            $isoIdioma = $i->getIso();
            $imatge = $i->getImatge();

            if ($idioma != null) {
                foreach ($idioma->getTraduccions() as $t) {
                    if ($t->getVariable() === $isoIdioma) {
                        $formI .= '<tr>
                                    <td><img src="' . $imatge . '" alt="' . $imatge . '"></td>
                                    <td>' . $t->getVariable() . '</td>
                                    <td><input type="text" id="' . $isoIdioma . '" name="' . $isoIdioma . '" value="' . $t->getValor() . '" placeholder="Escriu una traducció..."></td>
                                  </tr>';
                    }
                }
            }else {
                $formI .= '<tr>
                            <td><img src="' . $imatge . '" alt="' . $imatge . '"></td>
                            <td>' . $isoIdioma . '</td>
                            <td><input type="text" id="' . $isoIdioma . '" name="' . $isoIdioma . '" value="" placeholder="Escriu una traducció..."></td>
                          </tr>';
            }
        }

        $formI .= '<tr>
                    <td colspan="3">
                        <div class="fe-sInputs">
                            <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                            <input type="submit" id="enviar" name="enviar" value="Enviar">
                        </div>
                   </td>
                  </tr></table></form>';

        include "templates/head.tpl.php";
        include "templates/header.tpl.php";
        include "templates/main-idioma-form.tpl.php";
        include "templates/footer.tpl.php";
    }
}

