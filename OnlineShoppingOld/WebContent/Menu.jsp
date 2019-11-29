<div id="templatemo_menu">
    	<ul>
            <li><a href="index.html" class="current">Home</a></li>
            <li><a href="subpage.html">Search</a></li>
            <li><a href="subpage.html">Books</a></li>            
            <li><a href="subpage.html">New Releases</a></li>  
            <li><a href="#">Company</a></li> 
            <li><a href="#">Contact</a></li>
            <li><a href="Login.jsp">Logout</a></li>
            <% 
            	String name = session.getAttribute("hello").toString(); 
            	out.print(name);
            %>
        </ul>
</div>