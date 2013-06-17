# Rajola

> A nifty Slick2D Tiling Pipeline with camera assistance

This is a **work in progress**, **open source**, class library for Slick2D the Java game engine that helps you in creating 2d games and using OpenGL.

**[View the documentation](https://bevilacqua.github.com/Rajola)**

## Introduction

The goal of **Rajola** is to provide Java game developers with a standardized way to implement a tile map in their games without the requirement for any external tools.

## What's included

Here are few functionalities that are (or will) be included:

-    **TileMap :** the glue between all the parts, contains the tiles; includes map layers
-    **TileLevel :** an alternative to the _TileMap_ which allows map creation through a pixel image
-    **TileMapCamera :** will handle map scrolling and smooth scrolling/centering
-    **Tile :** the smallest unit
-    **Sprite :** represents _Tile_ image, can be animated
-    **TileSpriteSheet :** a sprite sheet from wich images can be used in a _TileMap_ layer

## Compiling

An `ant` script lives in the root of the repo named `build.xml` just run it form the command line using

```
$ ant
```

or run it in **eclipse**

the resulting **jar** will be located at `build/jar/rajola.jar`

<hr/>

Two other ant commands are also available:

* `ant clean` removes the **build** directory
* `ant compile` compiles the `.java` files to `.class` files in the `build/classes` directory

## Contributing

The more we are, the more fun we have.

The project is still very experimental but you are welcome to **fork**, code, and send a pull request!

Want to contribute with **documentation** head over to the wiki.
