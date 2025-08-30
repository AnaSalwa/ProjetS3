<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <title>Hire Hub</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Css/Home.css">
    <link rel="stylesheet" href="mail.css">
    <link rel = "preconnect" href = "https://fonts.gstatic.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <script src="main.js" defer></script>
</head>
<body>
<header>
    <a href="#" class="logo"><span>H</span>ire<span>H</span>ub</a>
    <div class="menuToggle" onclick="toggleMenu();"></div>
    <ul class="navbar">
        <li><a href="Login.jsp" onclick="toggleMenu();">Connexion</a></li>
        <li><a href="#apropos" onclick="toggleMenu();">A propos</a></li>
        <li><a href="#header2" onclick="toggleMenu();">Découvrez</a></li>
        <li><a href="#blogs" onclick="toggleMenu();">Blog</a></li>
        <li><a href="#temoignage" onclick="toggleMenu();">Témoignage</a></li>
        <li><a href="#contact" onclick="toggleMenu();">Contactez-nous</a></li>
        <a href="SignUpChoice.jsp" class="btn-reserve"onclick="toggleMenu();">S'inscrire</a>
    </ul>
</header>
	<div class="content">
	<script src="https://unpkg.com/ionicons@5.4.0/dist/ionicons.js"></script>
	<section class="banniere" id="banniere">
	
	               
	<div class="banniere-texte">
	    <h2> "Joignez-vous à nous pour transformer la façon dont vous recrutez aujourd'hui !"</h2>
	<style>
	                    .banniere-texte{
	                        font-family: "Times New Roman" ;
	                        color: black;
	                        font-weight: bold; 
	                        text-align: center;
	                        transform: translate(-50%, -250%);
	                        top: 60%;
	                    }
	                    .banniere{
	                        position: relative;
	                        width: 100%;
	                        min-height: 100vh;
	                        display: flex;
	                        justify-content: center;
	                        align-items: center;
	                        background-image: url("Images/turquoise.png");
	                        background-size: cover;
	                        background-position: 60px right;
	                    }
	</style>
	</div>
               
                <style>
                    body {
                        font-family: Arial;
                        background-color: #f2f2f2;
                        margin: 0;
                        padding: 0;
                    }
                </style>
            </div>
	</section>
<br> <br><br><br>
<section class="apropos" id="apropos">
    <div class="row">
        <div class="col50">
        <h2 class="titre-texte" style="color: black;"><span>A</span> Propos De Nous</h2>
        <h3 style="color: black;"><li><span style="font-weight: normal;">Découvrez HireHub , votre partenaire de confiance pour simplifier et optimiser le processus de recrutement.</span></li></h3><br>
        <h3 style="color: black;"><li><span style="font-weight: normal;">Publication d'offres d'emploi intuitive.</span></li></h3><br>
        <h3 style="color: black;"><li><span style="font-weight: normal;">Notre engagement est d'optimiser votre processus de recrutement, de vous faire gagner du temps et de vous aider à construire une équipe exceptionnelle.</span></li></h3><br>


        </div>
        <div class="col50">
            <div class="img">
                <img src="Images/Home1.jfif" alt="image">
            </div>
        </div>
    </div>
    <style>
        .apropos p {
  font-size: 18px; /* ajustez la valeur en fonction de vos besoins */
}
    </style>
</section>
<section  class="header2">
        <div class="intro-slideshow">
          <img src="../view/images/dashboard.jpeg">
          <img src="../view/images/crudT.jpeg">
          <img src="../view/images/crudC.jpeg">
        </div>
        <div class="intro-header">
          <h2 class="titre-texte"><span>D</span>écouvrez</h2>
          <p>et profitez</p>
        </div>
       
</section>     
<br><br><br><br>
<section class="blogs" id="blogs"></section>
<div class="blog-section">
    <h2 class="titre-texte"> Derniers articles de <span>B</span>log</h2><br><br>
    <div class="blog-posts">
      <div class="blog-post">
        <h3>"Les avantages de suivre vos dépenses"</h3><br>
        <p> Il est important de suivre régulièrement ses dépenses, notamment pour prendre conscience de ses habitudes de dépenses, identifier les domaines où des économies peuvent être réalisées et maintenir un contrôle financier solide</p>
        <a href="#">Lire la suite</a>
      </div>
      <div class="blog-post">
        <h3>"Comment faire face aux dépenses d'urgence?"</h3><br>
        <p>La constitution d'un fonds d'urgence, l'obtention d'une assurance adéquate et la recherche de moyens de réduire les dépenses superflues en cas de besoin</p>
        <a href="#">Lire la suite</a>
      </div>
      <div class="blog-post">
        <h3>"Les différentes méthodes pour épargner efficacement"</h3><br>
        <p> Le suivi des objectifs d'épargne, l'automatisation des transferts vers un compte d'épargne et l'utilisation d'applications ou d'outils de gestion financière pour faciliter le processus</p>
        <a href="#">Lire la suite</a>
      </div>
    </div>
  </div>
</section>
<section class="temoignage" id="temoignage">
    <div class="titre blanc">
        <h2 class="titre-texte">Que Disent Nos <span>C</span>lients?</h2>
    </div>
    <div class="contenu">
        <div class="box">
            <div class="imbox">
                <img src="../view/images/client.jpeg" alt="">
            </div>
            <div class="text">
                <h3>Maria Hatim</h3>
            </div><br>
            <p>C'est très utile, J'aime bien!</p>
        </div>
        <div class="box">
            <div class="imbox">
                <img src="../view/images/client2.jpeg" alt="">
            </div>
            <div class="text">
                <h3>Omar Bennis</h3>
            </div><br>
            <p>Génial. Rien à dire.</p>
        </div>
        <div class="box">
            <div class="imbox">
                <img src="../view/images/client3.jpeg" alt="">
            </div>
            <div class="text">
                <h3>Iness Bennani</h3>
            </div><br>
            <p>C'est pratique, ça m'a beaucoup aidé.</p>
        </div>
 </section>
 <br><br>
<section class="contact" id="contact">
     <div class="titre noir">
         <h2 class="titre-text"><span>C</span>ontact</h2>
         <p>N'hésitez pas de nous contacter pour nous aider à ameliorer notre projet à travers vos suggestions et vos remarques.</p>
     </div>
     <div class="contactform">
         <h3>Envoyer un message</h3>
         <div class="inputboite">
             <input type="text" placeholder="Nom">
         </div>
         <div class="inputboite">
            <input type="text" placeholder="email">
         </div>
         <div class="inputboite">
            <textarea placeholder="message"></textarea>
         </div>
         <div class="inputboite">
             <input type="submit" value="envoyer">
         </div>
     </div>
     <style>
        .contact{
            background-image: url("../view/images/contactus.jpg");}
     </style>
 </section>
 <div class="copyright">
     <p>copyright 2023 <a href="#">Salwa KHALED & Fatima-ezzahra SALHI</a> PFA. Tous droits reservés</p>
 </div>
 <script type="text/javascript">
     window.addEventListener('scroll', function(){
         const header =document.querySelector('header');
         header.classList.toggle("sticky", window.scrollY > 0 );
     });

     function toggleMenu(){
         const tmenuToggle = document.querySelector('.menuToggle');
         const navbar = document.querySelector('.navbar');
         navbar.classList.toggle('active');
         menuToggle.classList.toggle('active');
     }
 </script>
             
                <div class="icons">
                    <a href="#"><ion-icon name="logo-facebook"></ion-icon></a>
                    <a href="#"><ion-icon name="logo-instagram"></ion-icon></a>
                    <a href="#"><ion-icon name="logo-twitter"></ion-icon></a>
                    <a href="#"><ion-icon name="logo-google"></ion-icon></a>
                    <a href="#"><ion-icon name="logo-skype"></ion-icon></a>
                    <a href="#"><ion-icon name="logo-snapchat"></ion-icon></a>
                </div>
                <style>
                    .icons ion-icon {
                    color:#4f1ffb;
                    font-size: 1.5em;
                   }
                </style>
</body>
</html>