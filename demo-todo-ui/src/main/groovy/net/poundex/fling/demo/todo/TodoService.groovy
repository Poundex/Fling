package net.poundex.fling.demo.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by poundex on 09/06/17.
 */
@Service
class TodoService
{
	private final TodoServiceClient todoServiceClient
	private final CategoryServiceClient categoryServiceClient

	private Map<Long, CategoryModel> categoriesCache

	@Autowired
	TodoService(TodoServiceClient todoServiceClient, CategoryServiceClient categoryServiceClient)
	{
		this.todoServiceClient = todoServiceClient
		this.categoryServiceClient = categoryServiceClient
	}

	TodoModel get(long id)
	{
		return todoServiceClient.get(id).with {
			category = findCategory(category.id)
			it
		}
	}

	List<CategoryModel> getCategories()
	{
		if(categoriesCache == null)
			fetchCategories()

		return categoriesCache.values().asList().asImmutable()
	}

	CategoryModel findCategory(Long id)
	{
		if(categoriesCache == null)
			fetchCategories()

		return categoriesCache[id]
	}

	private void fetchCategories()
	{
		categoriesCache =
				categoryServiceClient.index().collectEntries { m -> [m.id, m] }
	}

	TodoModel save(Long id, TodoModel todoModel)
	{
		todoModel.category = findCategory(todoModel?.category?.id)
		return todoServiceClient.save(id, todoModel).with {
			it.category = findCategory(it.category.id)
			it
		}
	}

	TodoModel save(TodoModel todoModel)
	{
		todoModel.category = findCategory(todoModel?.category?.id)
		return todoServiceClient.save(todoModel).with {
			it.category = findCategory(it.category.id)
			it
		}
	}
}
