<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>About Us</title>
    <link rel="stylesheet" href="style.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
<style>
.timeline {
  position: relative;
  padding: 0;
  list-style: none;
}
.timeline:before {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 40px;
  width: 2px;
  margin-left: -1.5px;
  content: "";
  background-color: #e9ecef;
}
.timeline > li {
  position: relative;
  min-height: 50px;
  margin-bottom: 50px;
}
.timeline > li:after, .timeline > li:before {
  display: table;
  content: " ";
}
.timeline > li:after {
  clear: both;
}
.timeline > li .timeline-panel {
  position: relative;
  float: right;
  width: 100%;
  padding: 0 20px 0 100px;
  text-align: left;
}
.timeline > li .timeline-panel:before {
  right: auto;
  left: -15px;
  border-right-width: 15px;
  border-left-width: 0;
}
.timeline > li .timeline-panel:after {
  right: auto;
  left: -14px;
  border-right-width: 14px;
  border-left-width: 0;
}
.timeline > li .timeline-image {
  position: absolute;
  z-index: 100;
  left: 0;
  width: 80px;
  height: 80px;
  margin-left: 0;
  text-align: center;
  color: white;
  border: 7px solid #e9ecef;
  border-radius: 100%;
  background-color: #ff523b;
}
.timeline > li .timeline-image h4, .timeline > li .timeline-image .h4 {
  font-size: 10px;
  line-height: 14px;
  margin-top: 12px;
}
.timeline > li.timeline-inverted > .timeline-panel {
  float: right;
  padding: 0 20px 0 100px;
  text-align: left;
}
.timeline > li.timeline-inverted > .timeline-panel:before {
  right: auto;
  left: -15px;
  border-right-width: 15px;
  border-left-width: 0;
}
.timeline > li.timeline-inverted > .timeline-panel:after {
  right: auto;
  left: -14px;
  border-right-width: 14px;
  border-left-width: 0;
}
.timeline > li:last-child {
  margin-bottom: 0;
}
.timeline .timeline-heading h4, .timeline .timeline-heading .h4 {
  margin-top: 0;
  color: inherit;
}
.timeline .timeline-heading h4.subheading, .timeline .timeline-heading .subheading.h4 {
  text-transform: none;
}
.timeline .timeline-body > ul,
.timeline .timeline-body > p {
  margin-bottom: 0;
}

@media (min-width: 768px) {
  .timeline:before {
    left: 50%;
  }
  .timeline > li {
    min-height: 100px;
    margin-bottom: 100px;
  }
  .timeline > li .timeline-panel {
    float: left;
    width: 41%;
    padding: 0 20px 20px 30px;
    text-align: right;
  }
  .timeline > li .timeline-image {
    left: 50%;
    width: 100px;
    height: 100px;
    margin-left: -50px;
  }
  .timeline > li .timeline-image h4, .timeline > li .timeline-image .h4 {
    font-size: 13px;
    line-height: 18px;
    margin-top: 16px;
  }
  .timeline > li.timeline-inverted > .timeline-panel {
    float: right;
    padding: 0 30px 20px 20px;
    text-align: left;
  }
}
@media (min-width: 992px) {
  .timeline > li {
    min-height: 150px;
  }
  .timeline > li .timeline-panel {
    padding: 0 20px 20px;
  }
  .timeline > li .timeline-image {
    width: 150px;
    height: 150px;
    margin-left: -75px;
  }
  .timeline > li .timeline-image h4, .timeline > li .timeline-image .h4 {
    font-size: 18px;
    line-height: 26px;
    margin-top: 30px;
  }
  .timeline > li.timeline-inverted > .timeline-panel {
    padding: 0 20px 20px;
  }
}
@media (min-width: 1200px) {
  .timeline > li {
    min-height: 170px;
  }
  .timeline > li .timeline-panel {
    padding: 0 20px 20px 100px;
  }
  .timeline > li .timeline-image {
    width: 170px;
    height: 170px;
    margin-left: -85px;
  }
  .timeline > li .timeline-image h4, .timeline > li .timeline-image .h4 {
    margin-top: 40px;
  }
  .timeline > li.timeline-inverted > .timeline-panel {
    padding: 0 100px 20px 20px;
  }
}

.page-section {
  padding: 6rem 0;
}
.page-section h2.section-heading, .page-section .section-heading.h2 {
  font-size: 2.5rem;
  margin-top: 0;
  margin-bottom: 1rem;
}
.page-section h3.section-subheading, .page-section .section-subheading.h3 {
  font-size: 1rem;
  font-weight: 400;
  font-style: italic;
  font-family: "Roboto Slab", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
  margin-bottom: 4rem;
}

@media (min-width: 768px) {
  section {
    padding: 9rem 0;
  }
}

.text-center {
    text-align: center !important;
}

.page-section h2.section-heading, .page-section .section-heading.h2 {
    font-size: 2.5rem;
    margin-top: 0;
    margin-bottom: 1rem;
}
.text-uppercase {
    text-transform: uppercase !important;
}

.page-section h3.section-subheading, .page-section .section-subheading.h3 {
    font-size: 1rem;
    font-weight: 400;
    font-style: italic;
    font-family: "Roboto Slab", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
    margin-bottom: 4rem;
}

.text-muted {
    --bs-text-opacity: 1;
    color: #6c757d !important;
}

p {
    line-height: 1.75;
}
@media (min-width: 1400px)
.container-xxl, .container-xl, .container-lg, .container-md, .container-sm, .container {
    max-width: 1320px;
}
@media (min-width: 1200px)
.container-xl, .container-lg, .container-md, .container-sm, .container {
    max-width: 1140px;
}
@media (min-width: 992px)
.container-lg, .container-md, .container-sm, .container {
    max-width: 960px;
}
@media (min-width: 768px)
.container-md, .container-sm, .container {
    max-width: 720px;
}
@media (min-width: 576px)
.container-sm, .container {
    max-width: 540px;
}
.container, .container-fluid, .container-xxl, .container-xl, .container-lg, .container-md, .container-sm {
    width: 100%;
    padding-right: var(--bs-gutter-x, 0.75rem);
    padding-left: var(--bs-gutter-x, 0.75rem);
    margin-right: auto;
    margin-left: auto;
}
*, *::before, *::after {
    box-sizing: border-box;
}
user agent stylesheet
div {
    display: block;
}
</style>
  </head>
  <body>
  <%@ include file="header.jsp"%>
<!-- ---------ABOUT-------- -->
<div class="account-page">
<section class="page-section" id="about">
  <div class="container">
      <div class="text-center">
          <h2 class="section-heading text-uppercase">About Us</h2>
          <h3 class="section-subheading text-muted">Some information about our shop.</h3>
      </div>
      <ul class="timeline">
          <li>
              <div class="timeline-image"><img class="rounded-circle img-fluid" src="images" alt=""></div>
              <div class="timeline-panel">
                  <div class="timeline-heading">
                      <h4>1992-2002</h4>
                      <h4 class="subheading">Values And Beliefs</h4>
                  </div>
                  <div class="timeline-body"><p class="text-muted">We are treat the customer as god. Sales are good due to low profit business, customers are satisfied with us because of the price</p></div>
              </div>
          </li>
          <li class="timeline-inverted">
              <div class="timeline-image"><img class="rounded-circle img-fluid" src="images" alt=""></div>
              <div class="timeline-panel">
                  <div class="timeline-heading">
                      <h4>2002-2012</h4>
                      <h4 class="subheading">Build A Connection</h4>
                  </div>
                  <div class="timeline-body"><p class="text-muted">We are treat the customer as god. Sales are good due to low profit business, customers are satisfied with us because of the price</p></div>
              </div>
          </li>
          <li>
              <div class="timeline-image"><img class="rounded-circle img-fluid" src="images" alt=""></div>
              <div class="timeline-panel">
                  <div class="timeline-heading">
                      <h4>2012-2022</h4>
                      <h4 class="subheading">Certifications, Awards</h4>
                  </div>
                  <div class="timeline-body"><p class="text-muted">We are treat the customer as god. Sales are good due to low profit business, customers are satisfied with us because of the price</p></div>
              </div>
          </li>
          <li class="timeline-inverted">
              <div class="timeline-image"><img class="rounded-circle img-fluid" src="images" alt=""></div>
              <div class="timeline-panel">
                  <div class="timeline-heading">
                      <h4>2022-</h4>
                      <h4 class="subheading">Be interesting!</h4>
                  </div>
                  <div class="timeline-body"><p class="text-muted">We are treat the customer as god. Sales are good due to low profit business, customers are satisfied with us because of the price</p></div>
              </div>
          </li>
          <li class="timeline-inverted">
              <div class="timeline-image">
                  <h4>
                      Be Part
                      <br>
                      Of Our
                      <br>
                      Shop!
                  </h4>
              </div>
          </li>
      </ul>
  </div>
</section>
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
