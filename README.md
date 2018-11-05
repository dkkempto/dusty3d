# dusty3d
A ray tracer I'm making in my free time!

Super basic so far, only supports obj files with a relatively low polycount. WASD moves the camera translationally, arrow keys rotates the camera angle. Still pretty buggy, open to suggestions/improvements

Next steps include:

- Add lighting
- Add BRDF functionality
- Add reflection/refraction (not sure how this one's going to go, never really done anything like this in the past)
- Anti-aliasing? Easiest way would just be to super sample and then average that out
- Monte-carlo path tracer? That would be fun.
- Multithreading in lieu of that previous wish list entry
- Would be cool to see if Java has a way to drop down to GPU level, most likely by using some sort of OpenCL bindings
