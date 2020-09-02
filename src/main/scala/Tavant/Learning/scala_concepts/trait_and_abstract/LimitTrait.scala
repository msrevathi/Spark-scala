package Tavant.Learning.scala_concepts.trait_and_abstract

/*
You can also limit a trait so that it can only be added to classes that extend a
certain superclass. For example, if you want BallLover to be a trait that can only be
extended by subclasses of Pet, you just need to specify it so during its definition
 */

//class StarfleetComponent
//trait WarpCore extends StarfleetComponent
class Starship extends StarfleetComponent with WarpCore

/*
However, in the following example, the Warbird can’t extend the WarpCore trait because
Warbird and WarpCore don’t share the same superclass:
 */
class StarfleetComponent
trait WarpCore extends StarfleetComponent
class RomulanStuff
// class Warbird extends RomulanStuff with WarpCore   // won't compile

/*
You can mark your traits so they can only be used by subclasses of a certain type.
To do this, begin your trait with the “this: LimitingType =>” statement, as shown here:
 */

trait MyTrait {
  // this: LimitingType =>
}
  // more code here ...
 /* For instance, to make sure a WarpCore can only be used in a
 Starship, mark the WarpCore trait like this: */

  trait WarpCores {
    this: Starship => ""
  }