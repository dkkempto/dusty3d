# dusty3d
A ray tracer I'm making in my free time!

Super basic so far, only supports obj files with an extremely low polycount, seeing as there are no acceleration structures and it all runs on a single thread.

Next steps include:

Implementing the "Mesh" class to enable grouping triangles together.
Implement a k-d tree inside of Mesh to enable much, much faster rendering.
Add lighting classes
Add BRDF functionality
Add reflection/refraction (not sure how this one's going to go, never really done anything like this in the past)
Anti-aliasing? Easiest way would just be to super sample and then average that out
Monte-carlo path tracer? That would be fun.
Multithreading in lieu of that previous wish list entry
Would be cool to see if Java has a way to drop down to GPU level, most likely by using some sort of OpenCL bindings
