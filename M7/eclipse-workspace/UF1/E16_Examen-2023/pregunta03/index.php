<?php
/* La meva parella està preparant les opsicions per pofessor de biologia i ha tobat una pàgina web
 * "oposinet" on hi ha el temari per poder estudiar.
 * Quan volia descarregar-se (fent un "Desa com a") la pàgina ha vist que està bloquejat per
 * no poder fer us del botó dret. Aquest bloqueig es va amb un script de javascript.
 * 
 * https://www.oposinet.com/temario-de-biologia/temario-2-biologia-geologia/tema-47-ecologa-poblaciones-comunidades-y-ecosistemas-dinmica-de-las-poblaciones-interacciones-en-el-ecosistema-relaciones-intra-e-interespecficas-2/
 * Com no tens internet, he descarregat l'html i el tens disponible: http://192.168.19.0/UF1_2023/Examen/pregunta03/tema01.html
 * 
 * Ajuda a la meva parella per tal que pugi descarregar-se aquesta pàgina amb la informació que
 * conté.
 */

$ruta = "http://192.168.19.0/UF1_2023/Examen/pregunta03/tema01.html";
$contingut = file_get_contents($ruta);

//var_dump($contingut);

$html1 = strpos($contingut, "<html");
$html2 = strpos($contingut, "</html>");
$html = substr($contingut, $html1, $html2);

$resultat = $html;

echo $resultat;

