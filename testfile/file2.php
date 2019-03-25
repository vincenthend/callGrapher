<?php
class UserController {
  function showProfile($username){
      $connection = new SQLConnector();
      $a = 1;
      $dm = null;
      if($a == 1){
          $dm = new DataModel();
      } else {
          $dm = new DataMoodle();
      }
    $userdata = $dm->getUserData($username, $connection);
    showview('template.php', $userdata);
  }
}
?>