package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class HelloControllerSpec
  extends PlaySpec
  with GuiceOneAppPerTest
  with Injecting {
  "Hello Controller GET" should {
    "/helloにGETでアクセスできる" in {
      val request = FakeRequest(GET, "/hello")
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some("text/plain")
      contentAsString(home) mustBe "Hello, World!"
    }
  }

  "Hello Controller POST" should {
    "/helloにPOSTでJSONが取得できる" in {
      val request = FakeRequest(POST, "/hello")
      val home = route(app, request).get

      status(home) mustBe CREATED
      contentType(home) mustBe Some("application/json")
      contentAsJson(home) mustBe Json.obj("hello" ->  "Hello", "language" -> "scala")
    }
  }
}
