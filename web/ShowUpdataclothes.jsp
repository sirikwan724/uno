<%-- 
    Document   : updataclothes
    Created on : 18 ก.ค. 2567, 14:12:07
    Author     : Siric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.addclothes" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Edit clothes</h1>
        <% 
            
            addclothes newclothes = (addclothes) session.getAttribute("addclothes");
        
        %>
        <p>correctdataclothes</p>
        <form action="addnewclothesservlet2" method="post">
            <label for="clothesname">Name clothes:</label><br>
            <input type="text" id="clothesname" name="clothesname" value="<%= newclothes.getclothesname()%>" required><br>

            <label for="clothes">clothes</label><br>
            <select id="clothes" name="clothes">
                <option value="t-shirt" <%= newclothes.getclothes().equals("Casual") ? "selected" : ""%>>t-shirt</option>
                <option value="coat" <%= newclothes.getclothes().equals("Formal") ? "selected" : ""%>>coat</option>
                <option value="tanktop" <%= newclothes.getclothes().equals("Sportswear") ? "selected" : ""%>>tanktop</option>
                <option value="suitjacket" <%= newclothes.getclothes().equals("Nightwear") ? "selected" : ""%>>suitjacket</option>
            </select><br>

            <label>Site:</label><br>
            <input type="checkbox" id="site1" name="site" value="S" <%= newclothes.getsite().equals("S") ? "checked" : ""%>>
            <label for="site1">S</label><br>
            <input type="checkbox" id="site2" name="site" value="M" <%= newclothes.getsite().equals("M") ? "checked" : ""%>>
            <label for="site2">M</label><br>
            <input type="checkbox" id="site3" name="site" value="L" <%= newclothes.getsite().equals("L") ? "checked" : ""%>>
            <label for="site3">L</label><br>
            <input type="checkbox" id="site4" name="site" value="XL" <%= newclothes.getsite().equals("XL") ? "checked" : ""%>>
            <label for="site4">XL</label><br>

            <label>Color:</label><br>
            <input type="radio" id="color1" name="color" value="black" <%= newclothes.getcolori().equals("black") ? "checked" : ""%>>
            <label for="color1">black</label><br>
            <input type="radio" id="color2" name="color" value="white" <%= newclothes.getcolori().equals("white") ? "checked" : ""%>>
            <label for="color2">white</label><br>
            <input type="radio" id="color3" name="color" value="pink" <%= newclothes.getcolori().equals("pink") ? "checked" : ""%>>
            <label for="color3">pink</label><br>
            <input type="radio" id="color4" name="color" value="blue" <%= newclothes.getcolori().equals("blue") ? "checked" : ""%>>
            <label for="color4">blue</label><br>

            <label for="clothesprice">Price:</label><br>
            <input type="text" id="clothesprice" name="clothesprice" value="<%= newclothes.getclothesprice()%>" required><br>

            <input type="submit" value="Edit Clothes"><br/>
            <button onclick="window.location.href = 'index.html';">HOME</button>
        </form>

        <% session.removeAttribute("newclothes");%>
    </body>
</html>
