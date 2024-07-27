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

  <title>szamaDLAleniwych</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.css" rel="stylesheet">


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="UserHomePage">
      <div class="sidebar-brand-text mx-3">szamaDLAleniwych</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider">


    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="SearchHistory${userId}">
        <span>Historia wyszukiwań</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="FoodIngredients${userId}">
        <span>Moje składniki</span></a>
    </li>
    <hr class="sidebar-divider">
    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="NameOfTheMeal${userId}">
        <span>Inspiracje</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">

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

        <!-- Topbar Search -->
        <div>  <h4> Przypomnij co jadłeś </h4></div>


        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <div class="topbar-divider d-none d-sm-block"></div>

          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">Moje konto</span>
            </a>
            <!-- Dropdown - User Information -->

            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

              <a class="dropdown-item"   href="UserSettings${userId}" >
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                Ustawienia konta
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="/Logout"  data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Wyloguj się
              </a>
            </div>
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">
        <c:if test="${param.Success != null}">
          <div class="alert alert-success">
        Historia usunięta prawidłowo
          </div>
        </c:if>
        <form action="/DeleteSearchHistory${userId}" method="post" role="form" >
          <input type="submit" value="Wyczyść historie" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i></input>
        </form>

        <br><br><br>

        <!-- Content Row -->
        <div class="row">

        <!-- Content Row -->
        <div class="row">

          <!-- Content Column -->
          <div class="col-lg-6 mb-4">

            <!-- Project Card Example -->
            <div class="card shadow mb-4">

              <div class="card-header py-3">

                <h3 class="m-0 font-weight-bold text-primary">Inspiracje</h3>
              </div>
            <h5>
             <c:forEach var="inspirations" items="${inspirations}">
               <table>
               <tr>
                 <td>${inspirations.name}</td>
               </tr>
               </table>
              </c:forEach>
              </h5>
            </div>



          </div>

          <div class="col-lg-6 mb-4">

            <!-- Illustrations -->
            <div class="card shadow mb-4">
              <div class="card-header py-3">
               <h3 class="m-0 font-weight-bold text-primary">Moje składniki</h3>
              </div>
              <div class="card-body">
<h5>
                <p> <c:forEach var="foodIngredients" items="${foodIngredients}">
                <table>
                  <tr>
                    <td>${foodIngredients.firstIngredient}</td>
                    <td>${foodIngredients.secondIngredient}</td>
                    <td>${foodIngredients.thirdIngredient}</td>
                  </tr>
                </table>
                </c:forEach>
                </p>
                </h5>

              </div>
            </div>

</div>
          </div>
        </div>

      </div>
      <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->

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
