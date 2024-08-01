<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title> Contat Us </title>
    <link rel="stylesheet" href="style.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<style>
  * {
  box-sizing: border-box;
}

/* Style inputs */
input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #ff523b;
  color: white;
  padding: 8px 20px;
  border: none;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #dadada;
  color: #ff523b;
}

/* Create two columns that float next to eachother */
.column {
  float: left;
  width: 50%;
  margin-top: 6px;
  padding: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column, input[type=submit] {
    width: 100%;
    margin-top: 0;
    text-align: left;
  }
}
</style>
  </head>
  <body>
      <%@ include file="header.jsp"%>
<!-- ---------ABOUT-------- -->
<div class="account-page">
<div class="container">
  <div style="text-align:center">
    <h2>Contact Us</h2>
    <p>You can ask anything related to our shop.</p>
  </div>
  <div class="row">
    <!--<div class="column">
      <img src="/w3images/map.jpg" style="width:100%">
    </div>-->
    
    <div class="column">
      <form action="index.jsp" method="post">
        <label for="fname">Name</label>
        <input type="text" id="fname" name="firstname" placeholder="Your name..">
        <label for="lname">Number</label>
        <input type="number" id="lname" name="lastname" placeholder="Your Contact Number..">
        <label for="country">Reason</label>
        <select id="country" name="country">
          <option value="australia">Buy</option>
          <option value="australia">Sell</option>
          <option value="canada">Promotion</option>
          <option value="usa">Order</option>
        </select>
        <label for="subject">Subject</label>
        <textarea id="subject" name="subject" placeholder="Write something.." style="height: 170px"></textarea>
        <input type="submit" value="Submit">
      </form>
    </div>
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3666.91095501297!2d72.65926467437367!3d23.209915509312832!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x395c2baae9f6f05d%3A0x4f9616711f2fb4e5!2sNational%20Forensic%20Sciences%20University!5e0!3m2!1sen!2sin!4v1719757428852!5m2!1sen!2sin" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
</div>
</div>
     <%@ include file="footer.html"%>
    <!-- -------js for toggle menu----- -->
    <script>
      var MenuItems = document.getElementById("MenuItems");
      var MenuItem = document.getElementById("inneritems");
      MenuItems.style.maxHeight = "0px";
    
      function menutoggle(){
        if(MenuItems.style.maxHeight == "0px")
        {
         MenuItems.style.maxHeight = "200px";
        }
        else
        {
         MenuItems.style.maxHeight = "0px";
        }
       
      }
      function menutoggl(){
        if(MenuItem.style.display == "block")
        {
         MenuItem.style.display = "none";
        }
        else
        {
         MenuItem.style.display = "block";
        }
       
      }
         </script>


  </body>
</html>
