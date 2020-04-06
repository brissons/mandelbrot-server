<p align="center"> 
  <img src="mandelbrot-example.jpg">
</p>

# mandelbrot-service

> A server that returns an image from the Mandelbrot set.

The service endpoint is hosted on [Heroku](https://www.heroku.com/), and can be found [here](https://mandelbrot-service.herokuapp.com/mandelbrot). The first query may take a few moments to load.

The service is best utilized using the [front end application](https://github.com/brissons/mandelbrot-explorer).

## Built with

* [Spring Boot](https://spring.io/projects/spring-boot) - Service endpoint

## API

### /mandelbrot

#### GET
##### Description:

Retrieves an image of the Mandelbrot set.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| width | query | The width of the image. | No | integer |
| height | query | The height of the image. | No | integer |
| x | query | The x translation of the set. | No | number |
| y | query | The y translation of the set. | No | number |
| scale | query | The scale (zoom) of the set. | No | number |
| i | query | The number of iterations. Inceases detail at the expense of computation time. | No | number |
