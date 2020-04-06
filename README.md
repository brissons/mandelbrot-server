<p align="center"> 
  <img src="mandelbrot-intro.jpg">
</p>

# mandelbrot-service

> A servince that returns an image from the Mandelbrot set.

The service endpoint is hosted on [Heroku](https://www.heroku.com/), and can be found [here](https://mandelbrot-service.herokuapp.com/mandelbrot). The first query may take a few moments to load.

The service is best utilized using the [front end application](https://github.com/brissons/mandelbrot-explorer).

## Built with

* [Spring Boot](https://spring.io/projects/spring-boot) - Service endpoint

## API
**/mandelbrot**: Retrieves an image of the Mandelbrot set.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| width | query | The width of the image. | No | integer |
| height | query | The height of the image. | No | integer |
| x | query | The x translation of the set. | No | number |
| y | query | The y translation of the set. | No | number |
| scale | query | The scale (zoom) of the set. | No | number |
| i | query | The number of algorithm iterations (inceases detail). | No | number |

## Example

This [query](https://mandelbrot-service.herokuapp.com/mandelbrot?width=1920&height=1440&x=1069.1844985065172&y=535.9917714143127&scale=512&i=140) will return the following image:

<p align="center"> 
  <img src="mandelbrot-service-example.jpg">
</p>
