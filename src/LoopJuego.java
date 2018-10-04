
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import modelo.Carro;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer{
    private GraphicsContext lapiz;
    private Carro carro;
    Image imagefondo;
    Image gato;
    Image ufo;
    private int h;
    private int j;
    private int i;
    public LoopJuego(GraphicsContext lapiz) {
        this.imagefondo=new Image("Imagen/fondo.png");
        this.lapiz = lapiz;
        this.carro = new Carro(0, 100, 20, 20);
        this.gato=new Image("Imagen/cats.gif");
        this.ufo=new Image("Imagen/ufo_1.png");
    }
    @Override
    public void handle(long now) {
        int score=0;
        Shape rRectangulo1 = new Rectangle(20+j, 20, 50, 50);
        Shape rRectangulo2= new Rectangle(1000,20,10,10);
        Shape interseccion = SVGPath.intersect(rRectangulo1, rRectangulo2);
        lapiz.drawImage(imagefondo, 0, 0, 1024, 512);
        lapiz.drawImage(ufo, 980, 410, 40, 40);
        j++;
        lapiz.strokeRect(20+j, 20, 50, 50);
        lapiz.strokeRect(1000, 20, 10, 10);
        lapiz.drawImage(gato, 132*h, 0, 132, 80, 20+j, 410, 132, 80);
        if (interseccion.getBoundsInLocal().getWidth()!=-1){
            stop();
            score=+10;
        }
        if(h<=5){
            h++;
        }
        else{
            h=0;
        } 
        lapiz.strokeText("Puntaje: "+score, 200, 10);
        this.carro.mover();
    }
}
