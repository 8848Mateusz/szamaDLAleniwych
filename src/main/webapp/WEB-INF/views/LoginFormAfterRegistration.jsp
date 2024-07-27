<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Formularz logowania</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.css" rel="stylesheet">



</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="HomePage">
      <div class="sidebar-brand-text mx-3">szamaDLAleniwych</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">




  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <div>
          <h1 ></h1>

        </div>
        <!-- Approach -->
        <div class="card shadow mb-4">
          <div class="card-header py-3">
            <c:if test="${param.UpdateSuccessful != null}">
              <div class="alert alert-success">
                Pomyślnie zmieniono dane użytkownika. Zaloguj się korzystając z nowych danych.
              </div>
            </c:if>
            <c:if test="${param.logout != null}">
            <div class="alert alert-success">
              Wylogowano pomyślnie
            </div>
            </c:if>
            <c:if test="${param.success != null}">
              <div class="alert alert-success">
                Rejestracja przebiegła pomyślnie
              </div>
            </c:if>

            <c:if test="${param.error != null}">
              <div class="alert alert-danger">
                Nie prawidłowy adres e-mail lub hasło!
              </div>
            </c:if>
            <br><br>
            <h6>E-mail</h6>
            <form action="/LoginFormAfterRegistration" method="post" role="form" >
              <input type="email" name="username" id="username" placeholder="podaj swój e-mail ">

            <br><br>
              <label for="password"> Hasło </label>
              <br>
              <input type="password" id="password" name="password" itemid="password"  placeholder="podaj hasło" autocomplete="current-password" required=""/>
              <input type="checkbox" onclick="myFunction()">Show Password
              <script>
                function myFunction() {
                  var x = document.getElementById("password");
                  if (x.type === "password") {
                    x.type = "text";
                  } else {
                    x.type = "password";
                  }
                }
              </script>


            <div class="card-body">


            </div>
            <input type="submit" value="Zaloguj się" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i></input>
            </form>
          </div>

          <!-- Content Row -->
          <div class="row"></div>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Content Column -->
            <div class="col-lg-6 mb-4"></div>

            <div class="col-lg-6 mb-4">
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Mateusz Maciejewski Projekt Zaliczeniowy <a href="https://coderslab.pl/pl" target="_blank">CodersLab<a/> 2024</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>



  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
