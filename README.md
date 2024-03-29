# Dungeon Crawl ⚔️


  <p>
    <a href="https://en.wikipedia.org/wiki/Roguelike" >Roguelikes</a> are one of the oldest
types of video games. The earliest ones were made in the 70s, and they were inspired
a lot by tabletop RPGs. Roguelikes usually have the following features in common.

- They are tile-based.
- The game is divided into turns, that is, you take one action, then the other
  entities (monsters, allies, and so on, controlled by the CPU) take one.
- The task is usually to explore a labyrinth and retrieve some treasure from its
  bottom.
- They feature permadeath: if you die, it's game over, you need to start from the
  beginning again.

## About the project

This project's purpose was the help us learn the basics of Java and <a href="https://en.wikipedia.org/wiki/Object-oriented_programming">OOP</a>(Object Oriented Programming)
trough creating a tile based small game. <br />
The project is using `java` and `javafx`, so you'll need <a href="https://www.oracle.com/java/technologies/install-windows-64.html">JRE</a> or <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK</a> to run it.

### Team

[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/GagoRobi) - Róbert Gágó <br/>
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/GavallerVid) - Atilla Gavallér<br/>
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Europeanbeat) - Bence Bukovecz


### Built With

* [![Java][Java.com]][Java-url]
* [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)


<!-- GETTING STARTED -->
## Getting Started




### Installation

1. Clone the repository
   ```sh
   git clone https://github.com/CodecoolGlobal/mars-exploration-1-1q2023-java-GagoRobi
   ```
2. This is a Maven project, so you need to open pom.xml. 

3. The project uses
   JavaFX, so use the javafx Maven plugin to build and run the program.
   Build using `mvn javafx:compile`, and run
   using` mvn javafx:run` .


<!-- USAGE EXAMPLES -->
## Usage

Upon starting the game it should open a new window.

![img.png](src/main/resources/readmeImgs/img.png) <- This is your character in the bottom left part of the map!
<br/>
* You can move with the 'arrow' keys!
* Bumping into enemies will trigger a fight causing both of you to lose some health. Different enemies have different damage output!
* Walking into fire ![img_1.png](src/main/resources/readmeImgs/img_1.png) will instantly reduce your Healt Points to zero, causing th death of the character.
* Your job is to defeat the capturer ![img_3.png](src/main/resources/readmeImgs/img_3.png) of the Princess ![img_2.png](src/main/resources/readmeImgs/img_2.png) then save her!
* There are three item you can pick up! <br/>
![img_4.png](src/main/resources/readmeImgs/img_4.png) - The sword will increse the damage you deal to enemies (by 5)!<br/>
![img_5.png](src/main/resources/readmeImgs/img_5.png) - (E) A health potion that will regenerate your health to 20 HP! This is a one use item, that you can drink with the button `E`!
<br/> ![img_6.png](src/main/resources/readmeImgs/img_6.png) - The key is necessary for opening the doors to the final room!
* You DON'T! have to defeat all enemies, but you must defeat the creature in the last room!
* The game status and Inventory is displayed int the upper right corner of the app.<br/>
![img_7.png](src/main/resources/readmeImgs/img_7.png)<br/>
You can see your inventory, Hp, Dmg, and also the Win or Lose message.
![img_8.png](src/main/resources/readmeImgs/img_8.png)


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.


<!-- CONTACT -->
## Contact
[![LinkedIn][linkedin-shield]][linkedin-url] <br/>
#### Róbert Gágó
![gmail-shield]  - gagorobi96@gmail.com

Project Link: [https://github.com/CodecoolGlobal/mars-exploration-1-1q2023-java-GagoRobi]( https://github.com/CodecoolGlobal/mars-exploration-1-1q2023-java-GagoRobi)




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[gmail-shield]: https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/r%C3%B3bert-g%C3%A1g%C3%B3-a44578286/
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[Java.com]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/en/
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
[Github-s]:https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white
[JavaScript]:(https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
[Postgres]:(https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
[postgre-url]:(https://www.postgresql.org/)
[MongoDB]:(https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
[mongo-url]:(https://www.mongodb.com/)
[Spring]:(https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[spring-url]:(https://spring.io/)
