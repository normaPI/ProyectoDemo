package mx.npi.proyectodemo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class PantallaMenu extends Pantalla{
    // Referencia al juego principal
    private Juego juego;

    private Texture texturaFondo;

    //Escena
    private Stage escenaMenu;


    public PantallaMenu(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {
        crearMenu();
    }

    private void crearMenu() {
        texturaFondo = new Texture("menu/fondoT.jpeg");

        // MENU necesitamos una escena
        escenaMenu = new Stage(vista);

        //Actores... Boton
        Button btnMario = crearBoton("menu/BMario.png", "menu/BMarioInverso.png");
        btnMario.setPosition(ANCHO/3, 2*ALTO/3, Align.center);
        escenaMenu.addActor(btnMario);
        // REGISTRAR el evento de click para el boton
        btnMario.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Cambiar a pantalla (SpaceInveders)
                juego.setScreen(new PantallaMario(juego));
            }

        });

        Button btnSpace = crearBoton("menu/B1.png", "menu/B1inverso.png");
        btnSpace.setPosition(2*ANCHO/3, 2*ALTO/3, Align.center);
        escenaMenu.addActor(btnSpace);
        // REGISTRAR el evento de click para el boton
        btnSpace.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Cambiar a pantalla (SpaceInveders)
                juego.setScreen(new PantallaSpaceInvaders(juego));
            }

        });

        Button btnRunner = crearBoton("menu/BRunner.png", "menu/BRunnerInverso.png");
        btnRunner.setPosition(ANCHO/3, ALTO/3, Align.center);
        escenaMenu.addActor(btnRunner);
        // REGISTRAR el evento de click para el boton
        btnRunner.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Cambiar a pantalla (SpaceInveders)
                juego.setScreen(new PantallaRunner(juego));
            }

        });

        Button btnSettings = crearBoton("menu/BSettings.png", "menu/BSettingsInverso.png");
        btnSettings.setPosition(2*ANCHO/3, ALTO/3, Align.center);
        escenaMenu.addActor(btnSettings);
        // REGISTRAR el evento de click para el boton
        btnSettings.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Cambiar a pantalla (SpaceInveders)
                juego.setScreen(new PantallaSettings(juego));
            }

        });


        // LA ESCENA SE ENCARGA DE LOS EVENTOS DE ENTRADA
        Gdx.input.setInputProcessor(escenaMenu);
    }

    private Button crearBoton(String archivo, String archivoInverso) {
        Texture texturaBoton = new Texture(archivo);
        TextureRegionDrawable trdBtnMario = new TextureRegionDrawable(texturaBoton);
        // inverso
        Texture texturaInverso = new Texture(archivoInverso);
        TextureRegionDrawable trdBtnInverso = new TextureRegionDrawable(texturaInverso);

        return new Button(trdBtnMario,trdBtnInverso);
    }

    // Se ejecuta automaticamente 60times per second
    // delta es elm tiempo que ha transcurrido entre frames
    @Override
    public void render(float delta) {
        borrarPantalla(0,1,1);
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        batch.draw(texturaFondo,0,0);
        batch.end();

        // Escena (DESPUES DEL FONDO)
        escenaMenu.draw();
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
