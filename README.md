# bb-todo-api

A small todo service in Babashka, used to demonstrate working in a
sandbox with [devops.bb](https://github.com/kpassapk/devops.bb). It is
meant to be built in two parts:

- `todos.core`: the model. Pure functions over a store, no I/O.
- `todos.api`: a Ring handler over the model, served with http-kit.

```
bb test    # run the tests under test/
```

Handlers are plain Ring functions, `request -> response`, and are tested
by calling them with request maps. Babashka bundles http-kit and
cheshire, so there are no dependencies to resolve.
