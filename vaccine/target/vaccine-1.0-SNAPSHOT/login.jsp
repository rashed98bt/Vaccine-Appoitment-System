<%@page import="com.mycompany.vaccine.bean.PersonBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./ui/css/index.css" rel="stylesheet" type="text/css">
        <title>Vaccine Jo</title>
    </head>
    <body>
        <div class="main_caontainer">
        </div>
        <div class="login_form">
            <h1 style="color:#2196f3">Jordanian vaccine platform</h1>
                <form action="login" method="post">
                    <div class="input_Id">
                        <p> National ID </p>
                        <input type="number" name="id" required="true" />
                    </div>
                    <input type="submit" value="Enter" style="text-align: center" class="enterbtn"/>
                </form> 
            </div>
    </body>
</html>
