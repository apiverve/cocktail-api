from setuptools import setup, find_packages

setup(
    name='apiverve_cocktailrecipe',
    version='1.2.3',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Cocktail Recipe retrieves cocktail recipes by drink name or ingredient, providing measured ingredients, preparation instructions, and recommended glassware. Responses include serving categories and ingredient counts, with support for pulling random drinks.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/cocktail?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
