# Items Emission definition interfaces

**Emission** - a couple of items emission interfaces that are not tied to specific implementations, defining the capability
of item emission without specifying a particular execution model (synchronous or asynchronous).

## Brief overview

Two main constituents of the **Emission**:

* `Emittable`: defining features from both [Traverse Streams](https://github.com/MoodMinds/traverse-streams)
  and [Reactive Streams](https://github.com/MoodMinds/reactive-streams), this interface supports the emission of items.
  It allows emissions through traversals (synchronous `TraverseSupport`) or subscriptions (asynchronous `SubscribeSupport`),
  depending on the specific implementation.
* `Resource`: a representation of a backing resource that supports both synchronous and asynchronous execution, as indicated by `Emittable`.
  It must be either processed or explicitly declined to release the underlying resource.

## Maven configuration

Artifacts can be found on [Maven Central](https://search.maven.org/) after publication.

```xml
<dependency>
    <groupId>org.moodminds.emission</groupId>
    <artifactId>emission</artifactId>
    <version>${version}</version>
</dependency>
```

## Building from Source

You may need to build from source to use **Emission** (until it is in Maven Central) with Maven and JDK 1.8 at least.

## License
This project is going to be released under version 2.0 of the [Apache License][l].

[l]: https://www.apache.org/licenses/LICENSE-2.0