package geek.lawsof.physics.lib.energy.electric

import scalax.collection.GraphPredef._, scalax.collection.GraphEdge._
import scalax.collection.mutable.Graph

/**
 * Created by anshuman on 24-06-2014.
 */
trait IEnergyNet {
  val graph = Graph.empty[IElectricalNode, UnDiEdge]

  def connect (node: IElectricalNode, links: IElectricalNode*) = {
    graph += node
    links.foreach(graph += node ~ _)
  }

  def nodeAt (node: IElectricalNode) = graph get node
  def nodeAt (node: this.graph.NodeT) = node.value

  def path (origin: IElectricalNode, dest: IElectricalNode) = nodeAt(origin) shortestPathTo nodeAt(dest) getOrElse null
}

trait IElectricalNode {
  def resistance: ElectricalUnits.Ohm

  def capacitance: ElectricalUnits.Faraday

  def potential: ElectricalUnits.Volt

  def current: ElectricalUnits.Ampere
}


