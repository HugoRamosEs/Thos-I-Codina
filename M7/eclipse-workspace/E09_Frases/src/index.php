<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    
    require_once "bootstrap.php";

    use Frases\Entity\Autor;
    use Frases\Entity\Tema;
    use Frases\Entity\Frase;
    use Frases\Repository\TemaRepository;
    
//     CREAR UN REPOSITORI, CREAR UN MÉTODE I UTILITZAR-HO
    try {
        $temes = $entityManager->getRepository(Tema::class)->informacio();
        
        echo "<html>
        <head>
            <title>Frases Célebres</title>
            <link rel='stylesheet' type='text/css' href='styles.css'>
        </head>
        <body>
            <div id='contenedor'>
                <h1>Frases Célebres</h1>
                <h2 id='dql'>DQL</h2>
                <table>
                <thead>
                    <tr>
                        <th>Tema</th>
                        <th>Num. Frases</th>
                    </tr></thead>";
        foreach ($temes as $tema) {
            echo "<tr>";
            echo "<td>" . $tema["nombre"] . "</td>";
            echo "<td>" . $tema["num"] . "</td>";
            echo "</tr>";
        }
        echo "</tbody></table></body></html>";
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
