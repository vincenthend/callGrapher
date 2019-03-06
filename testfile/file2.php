<?php
class UserController {
  function showProfile($username){
    $dm = new DataModel();
    $userdata = $dm->getUserData($username);
    showview('template.php', $userdata);
  }
}
?>