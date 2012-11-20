<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

<?php
$data[] = Array('Category'=>'TrigonometricIdentities','Link'=>'trigonometric-identities.html');
$data[] = Array('Category'=>'Algebra','Link'=>'Hynninen');
$data[] = Array('Category'=>'Derivative','Link'=>'Pohjola');
$data[] = Array('Category'=>'Integrals','Link'=>'Tervonen');
$data[] = Array('Category'=>'Geometry','Link'=>'Hakuninen');
$data[] = Array('Category'=>'Vectors','Link'=>'Moilanen');

$search = $_GET['formulas'];

$arrIt = new RecursiveIteratorIterator(new RecursiveArrayIterator($data));

 foreach ($arrIt as $sub) {
    $subArray = $arrIt->getSubIterator();
    if ($subArray['Category'] === $search) {
        $outputArray[] = iterator_to_array($subArray);
    }
    else if ($subArray['Tags'] === $search){
        $outputArray[] = iterator_to_array($subArray);
        }
}

if (isset ($_GET['formulas']) && $search != "" && $search != " ") {
    if (is_array($outputArray)){
        foreach ($outputArray as $result => $row) {
            //echo  "Found: ". $row['Category'];
			header('Location: '.$row['Link'].'');
            }
        }
        else {
            echo "No results";
            }
    }
// print_r($data); // Array Dumppi
?>
        
    </tbody>
</table>
</body>
</html>