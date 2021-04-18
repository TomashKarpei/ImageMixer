	import java.awt.*;
	import java.awt.image.BufferedImage;
	import java.io.*;
	import javax.imageio.ImageIO;
	import javax.swing.JFrame;
	import java.math.*;
	public class Mieszanie_ciemn {
	 BufferedImage image_1, image_2, image;
	 int width;
	 int height;

	 public Mieszanie_ciemn() {

	 try {
	 //odczyt obrazu z pliku
	 File input1 = new File("meme_g.jpg");
	 File input2 = new File("FoW1.jpg");
	 image_1 = ImageIO.read(input1);
	 width = image_1.getWidth();
	 height = image_1.getHeight();
	 image_2 = ImageIO.read(input2);
	 //odczyt pixeli obrazu w dwóch pêtlach po kolumnach i wierszach
	 for(int i=0; i<height; i++){
	 for(int j=0; j<width; j++){
		 
	 //odczyt sk³adowych koloru RGB pierwszego zdjecia
	 Color c1 = new Color(image_1.getRGB(j, i));
	 double red_1 = (double)(c1.getRed());
	 double green_1 = (double)(c1.getGreen());
	 double blue_1 = (double)(c1.getBlue());


	 //odczyt sk³adowych koloru RGB drugiego zdjecia
	 Color c2 = new Color(image_2.getRGB(j, i));
	 double red_2 = (double)(c2.getRed());
	 double green_2 = (double)(c2.getGreen());
	 double blue_2 = (double)(c2.getBlue());
	 double a = 1;
	 double x = 0, y = 0, z = 0;
	 int red = 0, blue = 0, green = 0;
	 
	 	 if (red_1 / 255 < red_2 / 255) {
		 x = (red_1/255);
		 } else {
		 x = (red_2 / 255);
		 }
		 if (green_1 / 255 < green_2 / 255) {
		 y = green_1/255;
		 } else {
		 y = green_2/255;
		 }
		 if (blue_1 / 255 < blue_2 / 255) {
		 z = blue_1 / 255;
		 } else {
		 z = blue_2 / 255;
		 }



		 if (x * 255 > 255) {
			 red = 255;
		 } else {
			 red = (int) (x * 255);
		 }
		 if (y * 255 > 255) {
			 green = 255;
		 } else {
			 green = (int) (y * 255);
		 }
		 if (z * 255 > 255) {
			 blue = 255;
		 } else {
			 blue = (int) (z * 255);
		 }

	 Color newColor = new Color(red, green, blue);
	 image_1.setRGB(j,i,newColor.getRGB());

	 } //koniec dwóch pêtli po kolumnach i wierszach obrazu
	 }
	 //zapis do pliku zmodyfikowanego obrazu
	 File ouptut = new File("mieszanie_ciemn.jpg");
	 ImageIO.write(image_1, "jpg", ouptut);

	 } catch (Exception e) {}
	 }

	 static public void main(String args[]) throws Exception
	 {
		 Mieszanie_ciemn obj = new  Mieszanie_ciemn();
	 }
	}