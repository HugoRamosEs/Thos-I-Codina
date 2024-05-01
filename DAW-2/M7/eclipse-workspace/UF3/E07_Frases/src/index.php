<?php
//     error_reporting(E_ALL);
//     ini_set('display_errors', 1);
    
    require_once "bootstrap.php";
    
    use Frases\Entity\Autor;
    use Frases\Entity\Tema;
    use Frases\Entity\Frase;
    
//     CREAR ENTITATS AMB DADES DEL XML
    try {
        $xml = simplexml_load_file("../docs/frases.xml");
        
        foreach ($xml->autor as $nodeAutor) {
            $autor = $entityManager->getRepository(Autor::class)->findOneBy(['nombre' => (string)$nodeAutor->nombre]);
            if (!$autor) {
                $autor = new Autor();
                $autor->setNombre((string)$nodeAutor->nombre);
                $autor->setDescripcion((string)$nodeAutor->descripcion);
                $entityManager->persist($autor);
            }
            
            foreach ($nodeAutor->frases->frase as $nodeFrase) {
                $frase = $entityManager->getRepository(Frase::class)->findOneBy(['texto' => (string)$nodeFrase->texto]);
                if (!$frase) {
                    $frase = new Frase();
                    $frase->setTexto((string)$nodeFrase->texto);
                    
                    $temaNom = (string)$nodeFrase->tema;
                    $tema = $entityManager->getRepository(Tema::class)->findOneBy(['nombre' => $temaNom]);
                    
                    if (!$tema) {
                        $tema = new Tema();
                        $tema->setNombre($temaNom);
                        $entityManager->persist($tema);
                        $entityManager->flush();
                    }
                    
                    $frase->addTema($tema);
                    $entityManager->persist($frase);
                }
                
                $autor->addFrase($frase);
            }
        }
        
        $entityManager->flush();

//     MOSTRAR ENTITATS DESDE LA BASE DE DADES
    echo "<html>
        <head>
            <title>Frases Célebres</title>
            <link rel='stylesheet' type='text/css' href='styles.css'>
        </head>
        <body>
            <div id='contenedor'>
                <h1>Frases Célebres</h1>
                <h2>Entitats creades correctament</h2>
                <table>
                <thead>
                    <tr>
                        <th>Frase</th>
                        <th>Autor</th>
                        <th>Tema</th>
                    </tr></thead>";
            $frasesBd = $entityManager->getRepository('Frases\Entity\Frase')->findAll();
            foreach ($frasesBd as $fraseBd) {
                echo "<tr>";
                $autor = $fraseBd->getAutor();
                echo "<td>" . $autor->getNombre() . "</td>";
                echo "<td>" . $fraseBd->getTexto() . "</td>";
                echo "<td>";
                $temes = $fraseBd->getTemes();
                foreach ($temes as $tema) {
                    echo $tema->getNombre();
                }
                echo "</td></tr>";
            }
        echo "</div></table></body></html>";
        
    } catch (Exception $e) {
        echo "Error: " . $e->getMessage();
    }
