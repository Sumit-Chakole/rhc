<!doctype html>
<html lang="en">

<%
    String appVersion = "10";
%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="/">

    <title>Pick Drunken</title>

    <script>
        //Give sometime for anguar processing
        function appInitialisation() {
            setTimeout(function () {
                document.body.style.display = "block";
            }, 500);
        }

        appVersion= <%=appVersion%>;
    </script>

</head>
<body ng-app="rhcapp" ng-controller="appController as vm" ng-cloak
      onload="appInitialisation()" style="display: none">

<div class="rhc-page">
    <div class="rhc-header">
        <!-- Header starts -->
        <div class="rhc-header-container">

            <!-- App Name-->

            <div class="rhc-header-app-name">IOT Console</div>

        </div>
    </div>
    <div class="rhc-page-content">

        <!-- Partial views will load here -->
        <div ng-view class="rhc-partial-view-container"></div>

    </div>

    <div class="rhc-footer">
        <div class="footer-content">v<%=appVersion%></div>
    </div>

</div>

<!-- Angular JS-->
<script type="text/javascript" src="libs/angular.min.js"></script>
<script type="text/javascript" src="libs/angular-route.min.js"></script>

<!-- App css-->
<link href="css/app.css" rel="stylesheet"/>

<!-- App Module -->
<script type="text/javascript" src="modules/app.js?v=<%=appVersion%>"></script>
<!-- Routes -->
<script type="text/javascript" src="routes/routes.js?v=<%=appVersion%>"></script>
<!-- Strings -->
<script type="text/javascript" src="strings/strings.js?v=<%=appVersion%>"></script>
<!-- Server Endpoints -->
<script type="text/javascript"
        src="server-endpoints/server-endpoints.js?v=<%=appVersion%>"></script>

<!-- Services -->
<script type="text/javascript"
        src="services/datasource-service.js?v=<%=appVersion%>"></script>
<script type="text/javascript"
        src="services/navigation-service.js?v=<%=appVersion%>"></script>

<!-- App controllers -->
<script type="text/javascript" src="controller/app-controller.js?v=<%=appVersion%>"></script>
<script type="text/javascript" src="controller/dashboard-controller.js?v=<%=appVersion%>"></script>

</body>
</html>