// This program is a little implementation of asteroids. It shows keyboard
// events and the use of case classes to group data together.

import swing._
import event._
import java.awt. {Color,Shape}
import java.awt.geom._
import javax.swing.Timer

case class Asteroid(x:Double,y:Double,vx:Double,vy:Double,size:Double)
    case class Bullet(x:Double,y:Double,vx:Double,vy:Double,age:Int)

                val windowSize = 600
                                 val shipSize = 6

                    var asteroids = List.fill(5) {
                val theta = math.random*math.Pi*2
                            Asteroid(windowSize/2+math.cos(theta)*windowSize/4,
                                     windowSize/2+math.sin(theta)*windowSize/4,
                                     math.random-0.5,math.random-0.5,50)
            }
            var bullets = List[Bullet]()
                          var shipX = windowSize/2.0
                                      var shipY = windowSize/2.0
                                              var heading = 0.0
                                                      var shipVx = 0.0
                                                              var shipVy = 0.0
                                                                      var leftDown = false
                                                                              var rightDown = false

def wrap(x:Double):Double = {
    var nx = x
    while(nx < 0) nx += windowSize
        while(nx > windowSize) nx -= windowSize
            nx
        }

val panel = new Panel {
override def paint(g:Graphics2D) {
        g.setPaint(Color.black)
        g.fillRect(0,0,size.width,size.height)
        g.setPaint(Color.lightGray)
        for(a <- asteroids) g.fill(new Ellipse2D.Double(a.x-a.size/2,a.y-a.size/2,a.size,a.size))
            g.setPaint(Color.red)
            for(b <- bullets) g.fill(new Rectangle2D.Double(b.x,b.y,2,2))
                g.setPaint(Color.blue)
                g.fill(new Ellipse2D.Double(shipX-shipSize,shipY-shipSize,shipSize*2,shipSize*2))
                g.setPaint(Color.green)
                g.draw(new Ellipse2D.Double(shipX-shipSize,shipY-shipSize,shipSize*2,shipSize*2))
                g.fill(new Ellipse2D.Double(shipX+(shipSize+2)*math.cos(heading)-2,shipY+(shipSize+2)*math.sin(heading)-2,4,4))
            }
    listenTo(keys,mouse.clicks)
    reactions += {
    case kp:
        KeyPressed =>
        if(kp.key == Key.Left) leftDown = true
            else if(kp.key == Key.Right) rightDown = true
                else if(kp.key == Key.Up) {
                    shipVx += math.cos(heading)*0.2
                    shipVy += math.sin(heading)*0.2
                } else if(kp.key == Key.Down) {
                    shipVx -= math.cos(heading)*0.2
                    shipVy -= math.sin(heading)*0.2
                } else if(kp.key == Key.Space) {
                    bullets ::= Bullet(shipX+(shipSize+2)*math.cos(heading),shipY+(shipSize+2)*math.sin(heading),shipVx+3*math.cos(heading),shipVy+3*math.sin(heading),0)
                }
    case kp:
        KeyReleased =>
        if(kp.key == Key.Left) leftDown = false
            else if(kp.key == Key.Right) rightDown = false
            case me:
        MouseEntered => requestFocus
    }
    preferredSize = new Dimension(windowSize,windowSize)
}

val timer:
Timer = new Timer(10,Swing.ActionListener(e => {
    if(leftDown) heading -= math.Pi/40
        if(rightDown) heading += math.Pi/40
            asteroids = asteroids.map(a => {
            a.copy(x = wrap(a.x+a.vx), y = wrap(a.y+a.vy))
        })
    shipX = wrap(shipX+shipVx)
    shipY = wrap(shipY+shipVy)
    var hit = List[Asteroid]()
    bullets = bullets.map(b => {
        b.copy(x = wrap(b.x+b.vx), y = wrap(b.y+b.vy), age = b.age+1)
    }).filter(b => {
        b.age<100 && asteroids.forall(a => {
            val dx = b.x-a.x
            val dy = b.y-a.y
            val dsqr = dx*dx+dy*dy
            val isHit = dsqr < a.size*a.size/4
            if(isHit) hit ::= a
                !isHit
            })
    })
    asteroids = asteroids.flatMap(a => {
        if(hit.contains(a)) {
            if(a.size <=10) List()
                else List.fill(4)(Asteroid(a.x+(math.random-0.5)*a.size,a.y+(math.random-0.5)*a.size,a.vx+math.random-0.5,a.vy+math.random-0.5,a.size/2))
                } else List(a)
        })
    if(asteroids.exists(a => {
    val dx = shipX-a.x
    val dy = shipY-a.y
    val dsqr = dx*dx+dy*dy
    dsqr < (shipSize+a.size/2)*(shipSize+a.size/2)
    })) timer.stop()
    panel.repaint
}))

val frame = new MainFrame {
    contents = panel
    resizable = false
    centerOnScreen
}

frame.open
panel.requestFocus
timer.start
