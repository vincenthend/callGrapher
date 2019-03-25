<?php
class UserController {
  function showProfile($username){
      $connection = new SQLConnector();
    $dm = new DataModel();
    $userdata = $dm->getUserData($username, $connection);
    showview('template.php', $userdata);
  }
}
?>