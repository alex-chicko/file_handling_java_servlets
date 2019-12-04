<%-- 
    Document   : welcome
    Created on : 19 Σεπ 2019, 12:30:51 πμ
    Author     : ALEX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Welcome Page</title>
        <style>
  

            tr{
                background-color: white;
            }
                    body{
                        background-image: url("https://images.unsplash.com/photo-1496096265110-f83ad7f96608?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80");
                    }
        </style>
    </head>
    <body>
        <section class="container">
         <form action="uploadservlet" method="post" enctype="multipart/form-data">
            <input type="file" name="myfile" id="file-input" oninput="checkForm()">
            
            <input type="submit" id="Button" disabled="disabled">
        </form>
        <br>
  
       
       
        <table class="table table-bordered">
            <tbody>
                <tr class="warning">
                    <th><button type="button" class="btn btn-default">ID</button></th>
                    <th>FILENAME</th>
                    <th>DOWNLOAD</th>
                    <th>DELETE</th>
                        
                </tr>
          <c:forEach items="${files}" var="f">
              <tr>
                  <td> ${f.id}</td>
                  <td>   ${f.filename} </td>
                  <td><a href="download?id=${f.id}">Download</a></td>
                  <td><a href="delete?id=${f.id}">Delete</a></td>
                  
              </tr>
            </c:forEach>     
            </tbody>
        </table>
           
       </section>
  
        <script> 
            function checkForm() {
                if (document.getElementById("file-input").files.length != 0) {
                    document.getElementById("Button").disabled = false;
                }
            }
        </script>


         
      
               
    </body>
</html>
