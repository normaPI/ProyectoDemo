package mx.npi.proyectodemo;

/* Esta clase representa un clon del juego Space Invaders
Autor: Norma P Iturbide
 */

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class PantallaSpaceInvaders extends Pantalla {

    private Juego juego;

    // Enemigo
    private Array<Alien> arrAliens; // borrar

    // Nave
    private Nave nave;

    public PantallaSpaceInvaders(Juego juego) {
        this.juego = juego;
    }

    // Inicializan todos los objetos
    @Override
    public void show() {
        crearEnemigos();
        crearNave();

    }

    private void crearNave() {
        Texture texturaNave = new Texture("space/nave.png");
        nave = new Nave(texturaNave, ANCHO/2, 0.07f*ALTO);
    }

    private void crearEnemigos() {
        Texture textureAlien = new Texture("space/enemigoArriba.png");
        // alien = new Alien(textureAlien,ANCHO/2,ALTO/2);
        // Crear 55 Aliens
        arrAliens = new Array<>(11*5);
        for (int renglon = 0; renglon<5; renglon++){
            for (int columna = 0; columna<11; columna++){
                Alien alien = new Alien(textureAlien, 310 + columna*60, ALTO/2 + renglon*60);
                arrAliens.add(alien); // Lo guarda en el arreglo
            }
        }

    }

    @Override
    public void render(float delta) {
        borrarPantalla(0,0,0);

        batch.setProjectionMatrix(camara.combined);
        batch.begin();

        // alien.render(batch);
        // Quiero dibujar los 55 aliens que estan en el arreglo
        for (Alien alien: arrAliens) { // Automaticamente visita cada objeto del arreglo
            alien.render(batch);

        }
        nave.render(batch);

        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
