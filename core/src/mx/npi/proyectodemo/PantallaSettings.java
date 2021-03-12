package mx.npi.proyectodemo;

import com.badlogic.gdx.Screen;

public class PantallaSettings extends Pantalla {

    private Juego juego;

    public PantallaSettings(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        borrarPantalla(0,1,1);
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
