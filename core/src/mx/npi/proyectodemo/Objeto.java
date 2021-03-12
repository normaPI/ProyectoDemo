package mx.npi.proyectodemo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/* Esta clase representa objetos en el juego (Nave, Bala, Alien, Marcador, Enemigo...)
Autor: Norma P Iturbide
 */
public class Objeto {

    // Protected para que las clases que heredan puedan acceder a la variable
    protected Sprite sprite;// Imagen o Porsicion
    // Constructor. Inicializa el objeto con la imagen y la posicion
    public Objeto(Texture textura, float x, float y){
        sprite = new Sprite(textura);
        sprite.setPosition(x,y);
    }

    // Constructor por default
    public Objeto() {

    }

    // Dibujar el Objeto ->begin end <-
    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
