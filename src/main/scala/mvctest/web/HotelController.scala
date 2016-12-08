package mvctest.web

import java.lang.Long
import javax.validation.Valid

import mvctest.domain.Hotel
import mvctest.service.HotelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod}

@Controller
@RequestMapping(Array("/hotels"))
class HotelController @Autowired()(private val hotelRepository: HotelRepository) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model) : String = {
    val hotels = hotelRepository.findAll()
    model.addAttribute("hotels", hotels)
    "hotels/list"
  }

  @RequestMapping(Array("/edit/{id}"))
  def edit(@PathVariable("id") id: Long, model: Model) : String = {
    model.addAttribute("hotel", hotelRepository.findOne(id))
    "hotels/edit"
  }

  @RequestMapping(method = Array(RequestMethod.GET), params = Array("form"))
  def createForm(model: Model) : String = {
    model.addAttribute("hotel", new Hotel())
    "hotels/create"
  }

  @RequestMapping(method = Array(RequestMethod.POST))
  def create(@Valid hotel: Hotel, bindingResult: BindingResult) : String = {
    if (bindingResult.hasErrors) {
      "hotels/create"
    } else {
      hotelRepository.save(hotel)
      "redirect:/hotels"
    }
  }

  @RequestMapping(value = Array("/update"), method = Array(RequestMethod.POST))
  def update(@Valid hotel: Hotel, bindingResult: BindingResult) : String = {
    if (bindingResult.hasErrors) {
      "hotels/edit"
    } else {
      hotelRepository.save(hotel)
      "redirect:/hotels"
    }
  }

  @RequestMapping(value = Array("/delete/{id}"))
  def delete(@PathVariable("id") id: Long) : String = {
    hotelRepository.delete(id)
    "redirect:/hotels"
  }

}