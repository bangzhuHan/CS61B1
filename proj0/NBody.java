import org.testng.annotations.Test;

import java.util.Scanner;

public class NBody {
    /** read radius of planets in a certain txt file*/
    public static double readRadius(String file) {
        In in = new In(file);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /** read data of planets in a certain txt file*/
    public static Planet[] readPlanets(String file) {
        In in = new In(file);

        int num = in.readInt();
        Planet[] planets = new Planet[num];
        in.readDouble();    //the radius of the universe
        int count = 0;
        while(count < num) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double vX = in.readDouble();
            double vY = in.readDouble();
            double mass = in.readDouble();
            String pic = in.readString();
            planets[count] = new Planet(xP,yP,vX,vY,mass,pic);
            count++;
        }
        return planets;
    }

    public static void main(String[] args) {
       double T = Double.parseDouble(args[0]);
       double dt = Double.parseDouble(args[1]);
       String filename = args[2];
       double radius = readRadius(filename);
       Planet[] planets = readPlanets(filename);

       StdDraw.setScale(-radius, radius);

       StdDraw.enableDoubleBuffering();
       StdDraw.picture(0,0, "images/starfield.jpg");
       for(Planet p : planets){
           p.draw();
       }

       double t = 0;
       while(t < T){
           double[] xForces = new double[planets.length];
           double[] yForces = new double[planets.length];
           for (int i = 0; i < planets.length; i++) {
               xForces[i] = planets[i].calcNetForceExertedByX(planets);
               yForces[i] = planets[i].calcNetForceExertedByY(planets);
           }
           for (int i = 0; i < planets.length; i++) {
               planets[i] .update(t, xForces[i], yForces[i]);
           }
           StdDraw.picture(0,0, "images/starfield.jpg");
           for(Planet p : planets){
               p.draw();
           }
           StdDraw.show();
           StdDraw.pause(10);
           t += dt;
       }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }



}
