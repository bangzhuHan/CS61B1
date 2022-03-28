public class Planet {
    public double xxPos;      //当前x方向上的位置
    public double yyPos;     //当前y方向上的位置
    public double xxVel;    //在x方向上的当前速度
    public double yyVel;   //在y方向上的当前速度
    public double mass;    //质量
    public String imgFileName;  //与描绘行星的图像对应的文件名
    private double G = 6.67e-11;


    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }


    public double calcDistance(Planet rocinante){
        double x = this.xxPos - rocinante.xxPos;
        double y = this.yyPos - rocinante.yyPos;
        double result = Math.sqrt(x * x + y * y);
        return  result;
//        double ans = Math.sqrt(Math.pow((rocinante.xxPos-xxPos),2) +
//                Math.pow((rocinante.yyPos-yyPos),2));
//        return ans;
    }


    public double calcForceExertedBy(Planet rocinante){
        double r = this.calcDistance(rocinante);    //计算两颗行星间的距离
        double f = G * mass * rocinante.mass / (r * r);
        return f;
    }

    public double calcForceExertedByX(Planet rocinante){
        double F = this.calcForceExertedBy(rocinante);
        double result = F * (rocinante.xxPos - this.xxPos) / this.calcDistance(rocinante);
        return result;
    }

    public double calcForceExertedByY(Planet rocinante){
        double F = this.calcForceExertedBy(rocinante);
        double result = F * (rocinante.yyPos - this.yyPos) / this.calcDistance(rocinante);
        return result;
    }

    public double calcNetForceExertedByX(Planet[] rocinantes){
        double sum = 0.0;
        for (Planet planet: rocinantes) {
            if(this.equals(planet)){
                continue;
            }else   sum += this.calcForceExertedByX(planet);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] rocinantes){
        double sum = 0.0;
        for (Planet planet: rocinantes) {
            if(this.equals(planet)){
                continue;
            }else   sum += this.calcForceExertedByY(planet);
        }
        return sum;
    }

    public void update(double dt, double fX, double fY){
        double aX = fX / mass;
        double aY = fY / mass;
        double vX = this.xxVel + dt * aX;
        double vY = this.yyVel + dt * aY;
        this.xxVel = vX;
        this.yyVel = vY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw(){
        String file =  "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, file);
    }
}
