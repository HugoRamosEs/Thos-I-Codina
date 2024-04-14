<?php
class NavigationController extends Controller {
    public $lang;
    
    public function __construct() {
        $this->lang = new LanguageController();
    }

//     public function getHTMLNavigation() {
//         $html = "";
//         include $this->lang->getFitxerDeTraduccions();
    
//         foreach ($menuDeNavegacio as $codi => $item) {
//             if ($codi < 50) {
//                 if ($_SESSION["paginaActual"] == $codi) {
//                     $html .= "<li class='active'><a href='index.php?pg=$codi'>$item</a></li>\n";
//                 } else {
//                     $html .= "<li><a href='index.php?pg=$codi'>$item</a></li>\n";
//                 }
//             }
//         }
//         return $html;
//     }

    public function getHTMLNavigation() {
        $html = "";
        include $this->lang->getFitxerDeTraduccions();
        
        foreach ($menuDeNavegacio as $codi => $item) {
            if ($codi < 50) {
                if ($_SESSION["paginaActual"] == $codi) {
                    $html .= "<li class='active'><a href='index.php?Navigation/show/$codi'>$item</a></li>\n";
                } else {
                    $html .= "<li><a href='index.php?pg=$codi'>$item</a></li>\n";
                }
            }
        }
        return $html;
    }
    
    public function getHTMLUser() {
        $html = "";
        if (isset($_SESSION['usuari'])) {
            $bIdentificat = true;
            $sUserName = $_SESSION['usuari'];
            $sUserImage = $_SESSION['img'];
        } else {
            $bIdentificat=false;
            $sUserName = 'Accedeix';
            $sUserImage = '';
        }
        
        if ($bIdentificat) {
            $html .= "<li><a href='index.php?pg=98'><img src='$sUserImage'>$sUserName</a></li>";
        } else {
            $html .= "<li><a href='index.php?pg=99'>Accedeix</a></li>";
        }
        return $html;
    }
    
}