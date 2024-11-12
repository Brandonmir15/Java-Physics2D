


 # Collision Detection

# TODO: 
    Time Stepping
        float fps = 100;
        float dt = 1 / fps;
        float accumlator = 0;

        //  In unites of seconds
        // Idk how to pull current time, you got it though
        float frameStart = [getCurrentTime];
        
        // main loop
        -----------------------------------------------------


    Implement Mass
    Mass data types
    Material densities
    !!! Pairing method
    !!! Remove duplicate pairs method
    Currently we:
     - pair objects
     - inspect for intersection
     - resolve collision
    We can implement these into methods to make it easier
     - we're cooked
    As of current the way the loops and checks are implemented in the MainPanel is that every time we
    create a Physics2D Circle, the loop pairs the last circle with every other circle, and the
    intersection applies to the last circle [most recent created]
    
    I visually check this:
     - We can see that when the cirlces are spawned

# Collision Resolve
    V^(AB) * dot * normal = -e (V^(B) - V(A)) * dot * normal
    Resulting velocity [V'] with an applied force and direction
    Relative velocity with an applied force, direction, and multiplied by elasticity (Energy loss)
    The circle will collide and bounce in a given direction with a force [normal * dot]
    At a certain velocity [V^(AB)] with a given impulse (-e)
    e.min(A.elasticity, B.elasticity);
    Coefficient of restitution - Elasticity || Bounciness
    Only one decimal value will be used during impulse calculation for Epsilon [e]
    Using the lowest restitution involved in collision should give intuitive results
    Newtons Law of Restitution states that V' = e * V
    [velocity after collision] == [velocity before] * [constant]

# Mass Data
    float mass;
    float invMass;

    float inertia; //For rotations
    float inverseInertia;

# Materials
    float density; // Different materials 
    float restituion; //Elasticity (Epsilon [e])

# Broad Collision (Profiler)
    [HashMap]
    Pair objects for narrowCollision
     - return a HashMap
    [Sort HashMap]
     - sort entries
     - cull all duplicate pairs
    [Implement norrowCollision]
